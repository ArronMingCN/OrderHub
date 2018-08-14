package com.orderhub.controller;

import com.orderhub.entity.Order;
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

    @RequestMapping("placeOrder")
    public void placeOrder(HttpServletRequest request, HttpServletResponse response){
        Order ord = new Order(30,"LMT","TEST","BUY",30,1224.00);
        //place order
        //Integer orderid =this.getServiceManager().getOrderService().placeANewMKTOrder(ord);

        //processing order
//        if(orderid != -1){
//            ord.setOrderID(orderid);
//            if(ord.getBoS()=="BUY"){
//                this.getServiceManager().getOrderService().processingBidMKT(ord);
//            }
//            else if(ord.getBoS()=="SELL"){
//                this.getServiceManager().getOrderService().processingAskMKT(ord);
//            }else {
//                System.out.println("it's not buy or sell");
//            }
//        }

        Integer orderID;
        switch(ord.getOrderType()){
            case "LMT":
                orderID = this.getServiceManager().getOrderService().placeNewLMTOrder(ord);
                if(orderID !=-1){
                    ord.setOrderID(orderID);
                    this.getServiceManager().getOrderService().processingLMT(ord);


                }

                break;

        }





    }



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


}
