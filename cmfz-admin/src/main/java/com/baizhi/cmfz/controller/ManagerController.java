package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.ServletContext;
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

    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(String code,HttpSession session){
        String getVcode = (String) session.getAttribute("vercode");
        if (code!=null&&code.equalsIgnoreCase(getVcode)){
            return "success";
        }
        return "false";
    }

    @RequestMapping("/queryMgr")
    public String queryManager(String mgrName, String mgrPwd, String enCode, String remember, HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
        System.out.println(mgrName);
        System.out.println(mgrPwd);
        System.out.println(enCode);
        Manager manager = new Manager();
        manager = ms.queryManagerByName(mgrName);

        if (manager!=null){
            String s1 = manager.getMgrPwd();
            String s2 = mgrPwd+manager.getSalt();
            String checkedPwd = DigestUtils.md5Hex(s2);
            if (s1.equals(checkedPwd)){
                if (remember!=null){
                    String choice = "true";
                    Cookie cookieName = new Cookie("mgrName",URLEncoder.encode(manager.getMgrName(), "utf-8"));
                    Cookie choiceType = new Cookie("choiceChange",choice);
                    cookieName.setMaxAge(60*60*24);
                    choiceType.setMaxAge(60*60*24);
                    response.addCookie(cookieName);
                    response.addCookie(choiceType);
                    HttpSession session = request.getSession();
                    System.out.println(manager.getMgrName()+"--------------------");
                    session.setAttribute("loginingMgr",manager.getMgrName());
                }
               return  "main/main";
            }else{
                return "login";
            }
        }else{
            return "login";
        }
    }

    @RequestMapping("toLogin")
    public String toLogin(HttpServletRequest request, ModelMap map) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        String mgrName="";
        String choiceType="";
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("mgrName")){
                mgrName = URLDecoder.decode(cookie.getValue(),"utf-8");
            }
        }
        map.addAttribute("mgrName",mgrName);
        return "login";
    }
}
