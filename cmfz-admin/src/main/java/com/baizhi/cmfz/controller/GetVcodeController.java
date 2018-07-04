package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.util.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class GetVcodeController {
    @RequestMapping("/vcode")
    public String vcode(HttpServletResponse response, HttpSession session){
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);

        //生成随机字符串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);

        //存入会话
        //删除以前的
        session.setAttribute("vercode",verifyCode.toLowerCase());

        //生成图片
        int w =100 ,h =40;
        try {
            VerifyCodeUtils.outputImage(w,h,response.getOutputStream(),verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
