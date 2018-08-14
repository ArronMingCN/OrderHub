package com.orderhub.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class OrderBookController extends BaseController {


    @RequestMapping("/get/all")
    public void getOrderBook(HttpServletRequest request, HttpServletResponse response) throws IOException{

        Map<Integer, Map<String,Object>>  bidMap = this.getServiceManager().getOrderBookService().getOrderBookBidView("AAPL");
        Map<Integer, Map<String,Object>>  askMap = this.getServiceManager().getOrderBookService().getOrderBookAskView("AAPL");
        JSONObject jsonObject = new JSONObject();
        JSONArray bid = new JSONArray();
        for(Map<String,Object> record: bidMap.values()){
            JSONObject rec = new JSONObject();
            rec.put("size",record.get("Remainder"));
            rec.put("price",record.get("Price"));
            rec.put("key",record.get("OrderID"));
            bid.add(rec);
        }
        jsonObject.put("bid",bid);
        JSONArray ask = new JSONArray();
        for(Map<String,Object> record: askMap.values()){
            JSONObject rec = new JSONObject();
            rec.put("key",record.get("OrderID"));
            rec.put("price",record.get("Price"));
            rec.put("size",record.get("Remainder"));
            ask.add(rec);
        }
        jsonObject.put("ask",ask);
        response.setContentType("application/json");
        PrintWriter out =response.getWriter();

        //this.getServiceManager().getLoginService().getUserLoginResult("bryan","123456");

        out.print(jsonObject.toString());
    }

    /**
     * It's the api for GUI data
     * @param request
     * @param response
     * @throws IOException
     */
    //@RequestMapping("/get/all")
    public void testJson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out =response.getWriter();
        //String data ="{bid:[{key:1,price:201.42,size:40}],ask:[{key:1,price:202.32,size:23}]}";
        String data = "{\"bid\":[{\"key\":\"1\",\"price\":\"201.42\",\"size\":\"40\"}],\"ask\":[{\"key\":\"1\",\"price\":\"202.32\",\"size\":\"23\"}]}";
        out.print(data);
    }

}
