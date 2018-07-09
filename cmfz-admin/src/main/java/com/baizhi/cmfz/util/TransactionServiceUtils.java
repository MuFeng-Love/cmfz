package com.baizhi.cmfz.util;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @description 额外功能类
 *
 * @Create 2018-07-09 19:24
 */
@Aspect
public class TransactionServiceUtils {
    @Autowired
    private LogDao ld;

    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*Impl.modify*(..)) || execution(* com.baizhi.cmfz.service.impl.*Impl.remove*(..)) || execution(* com.baizhi.cmfz.service.impl.*Impl.add*(..))")
    public void pc(){}

    @Around("pc()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable{

        //获取Request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //获取session
        HttpSession session = request.getSession();

        //获取用户
        String user = (String) session.getAttribute("loginingMgr");

        //创建新事务对象
        Log log = new Log();

        //获取message
        String message = "";
        //先获取参数(拼接message)
        Object[] args = pjp.getArgs();
        for (Object o : args) {
            String message1 = args.toString();
            message = message.concat(message1);
        }

        //获取方法对象
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();

        //根据方法名首字母判断方法类型
        String name = method.getName();
        String fistName = name.substring(0,1);

        if (fistName.equals("a")) {
            log.setAction("添加");
        } else if (fistName.equals("m")) {
            log.setAction("修改");
        } else {
            log.setAction("删除");
        }

        //获取resource
        String oldName = methodSignature.getDeclaringTypeName();
        String resource = oldName.substring(oldName.lastIndexOf(".")+1) ;

        log.setMessage(message);
        log.setResource(resource);
        log.setUser(user);
        log.setTime(new Date());

        //获取状态
        Object obj = null;
        try{
            obj = pjp.proceed();
            log.setResult("success");
        } catch (Exception e){
            log.setResult("fail");
            e.printStackTrace();
        }

        ld.insertLog(log);
        return obj;


    }

}
