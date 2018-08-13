package com.orderhub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class OrderBookController extends BaseController {



    /**
     * It's the api for GUI data
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/get/all")
    public void testJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out =response.getWriter();
        //String data ="{bid:[{key:1,price:201.42,size:40}],ask:[{key:1,price:202.32,size:23}]}";
        String data = "{\"bid\":[{\"key\":\"1\",\"price\":\"201.42\",\"size\":\"40\"}],\"ask\":[{\"key\":\"1\",\"price\":\"202.32\",\"size\":\"23\"}]}";
        out.print(data);
    }
}
