package com.orderhub.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class OrderController extends BaseController {
    @RequestMapping("/tes")
    public ModelAndView visting(HttpServletRequest request, HttpServletResponse response){
        System.out.println("test");
        this.getServiceManager().getOrderBookService().getDaoManager().getTestDAO().test();
        return new ModelAndView("getTestPage");
    }
    @RequestMapping("/aaaa")
    public String vistings(HttpServletRequest request, HttpServletResponse response){
        System.out.println("test");
        this.getServiceManager().getOrderBookService().getDaoManager().getTestDAO().test();
        return "getTestPage";
    }
    @RequestMapping("/get/al")
    @ResponseBody
    public String greeting(){
        System.out.println(System.currentTimeMillis()+" here is json function");
        JSONObject a = new JSONObject();
        a.put('a',1);
        a.put('b',2);
        String ab = "{bid:[{key:1,price:201.42,size:40}],ask:[{key,1,price:202.32,size:23}]}";
        return ab;
    }
    @RequestMapping("/get/all")
    public void testJson(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out =response.getWriter();
        //String data ="{bid:[{key:1,price:201.42,size:40}],ask:[{key:1,price:202.32,size:23}]}";
        String data = "{\"bid\":[{\"key\":\"1\",\"price\":\"201.42\",\"size\":\"40\"}],\"ask\":[{\"key\":\"1\",\"price\":\"202.32\",\"size\":\"23\"}]}";
        out.print(data);
    }
}
