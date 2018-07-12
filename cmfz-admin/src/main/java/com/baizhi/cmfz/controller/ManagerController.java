package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
@RequestMapping("/mgr")
public class ManagerController {

    @Autowired
    private ManagerService ms;

    /**
     * @Description 验证码校验
     * @param code 前端获取输入的验证码
     * @param session 从session中获取比对的验证码
     * @return
     */
    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(String code,HttpSession session){
        String getVcode = (String) session.getAttribute("vercode");
        if (code!=null&&code.equalsIgnoreCase(getVcode)){
            return "success";
        }
        return "false";
    }

    /**
     * @Description 获取
     * @param mgrName
     * @param mgrPwd
     * @param enCode
     * @param response
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/queryMgr")
    public String queryManager(String mgrName, String mgrPwd,boolean rememberName,boolean rememberMe, String enCode, HttpServletResponse response,HttpServletRequest request) {

        //在web环境中安全管理器会自动进行初始化
        Subject subject = SecurityUtils.getSubject();

        System.out.println("rememberName: "+rememberName);
        System.out.println("rememberMe: "+rememberMe);

        subject.login(new UsernamePasswordToken(mgrName,mgrPwd,rememberMe));
        System.out.println(mgrName);
        System.out.println(mgrPwd);
        System.out.println(enCode);
        Manager manager = new Manager();
        manager = ms.queryManagerByName(mgrName);

        if (manager!=null){
            if (rememberName) {
                String choice = "true";
                Cookie cookieName = null;
                try {
                    cookieName = new Cookie("mgrName", URLEncoder.encode(manager.getMgrName(), "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return "login";
                }
                Cookie choiceType = new Cookie("choiceChange", choice);
                cookieName.setMaxAge(60 * 60 * 24);
                choiceType.setMaxAge(60 * 60 * 24);

                response.addCookie(cookieName);
                response.addCookie(choiceType);
                HttpSession session = request.getSession();
                System.out.println(manager.getMgrName() + "--------------------");
                session.setAttribute("loginingMgr", manager.getMgrName());
            }
            return  "main/main";
        }else{
            return "login";
        }
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request) throws Exception {

        Manager manager = (Manager)request.getSession().getAttribute("name");
        if(manager != null){
            request.getSession().setAttribute("manager", null);
        }
        return "login";
    }

    @RequestMapping("/checkUserName")
    @ResponseBody
    public String toLogin(HttpServletRequest request, ModelMap map) throws UnsupportedEncodingException {
        System.out.println("----------come in checkUserName-----------");
        Cookie[] cookies = request.getCookies();
        String mgrName="";
        String choiceType="";
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("mgrName")){
                mgrName = URLDecoder.decode(cookie.getValue(),"utf-8");
            }
        }
        map.addAttribute("mgrName",mgrName);
        return mgrName;
    }
}
