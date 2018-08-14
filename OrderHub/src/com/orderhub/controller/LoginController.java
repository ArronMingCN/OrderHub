package com.orderhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.SQLSyntaxErrorException;

@Controller
public class LoginController extends BaseController {

    @RequestMapping("/post/signin")
    public void testLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        String userID = request.getParameter("userid");
        String passWord = request.getParameter("password");
        String encryInfo =  this.getServiceManager().getMyUtil().encrypByMd5(userID+passWord);
        PrintWriter out =response.getWriter();
        if(this.getServiceManager().getLoginService().getUserLoginResult(encryInfo)){
            out.print(encryInfo);
        }
        else{
            out.print("-1");
        }

    }

    @RequestMapping("/post/test")
    public void testRegister(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        String userID ="6";//= request.getParameter("1");
        String passWord = "123456";//request.getParameter("123456");
        String encryInfo =  this.getServiceManager().getMyUtil().encrypByMd5(userID+passWord);
        this.getServiceManager().getLoginService().register(userID,encryInfo);

    }
}
