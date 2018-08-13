package com.orderhub.service;

import com.orderhub.entity.Order;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Map;

@Service
public class OrderService extends BaseServicce {


    /**
     * adding a new  market order
     * @param ord
     * @return
     */
    public Integer placeANewMKTOrder(Order ord){
        return getDaoManager().getOrderDAO().addNewMKTOrder(ord);
    }



    /**
     * processing a market order ,here is business logic
     * @param ord
     */
    public void processingBidMKT(Order ord){
        //get orderid,userid,ask price,remainder
        Map<Integer, Map<String,Object>>  askMap = this.getDaoManager().getOrderBookDAO().getOrderBookAskBySymbol(ord.getSymbol());
        int bidRemainder = ord.getQty();
        for(Map<String,Object> record: askMap.values()) {
            if(Integer.parseInt(record.get("remainder").toString()) > bidRemainder){
                try {
                    //update the seller's remainder value
                    this.getDaoManager().getOrderDAO().updateRemainderByOrderId("SELL",
                            Integer.parseInt(record.get("remainder").toString())-bidRemainder,
                            Integer.parseInt(record.get("OrderID").toString()));
                    //update the buyer's remainder value
                    this.getDaoManager().getOrderDAO().updateRemainderByOrderId("BUY",
                            0, ord.getOrderID());
                    //made a deal ,update
                    this.getDaoManager().getOrderDAO().addMathchedOrder(ord.getOrderID(),Integer.parseInt(record.get("OrderID").toString()),
                            ord.getUserID(),Integer.parseInt(record.get("UserID").toString()),ord.getSymbol(),
                            Double.parseDouble(record.get("Price").toString()),bidRemainder);
                    System.out.println("new order filled");
                    break;
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            this.getDaoManager().getOrderDAO().updateRemainderByOrderId("SELL",
                    0, Integer.parseInt(record.get("OrderID").toString()));
            bidRemainder = bidRemainder- Integer.parseInt(record.get("remainder").toString());
            this.getDaoManager().getOrderDAO().updateRemainderByOrderId(ord.getBoS(),bidRemainder,ord.getOrderID());
            this.getDaoManager().getOrderDAO().addMathchedOrder(ord.getOrderID(),Integer.parseInt(record.get("OrderID").toString()),
                    ord.getUserID(),Integer.parseInt(record.get("UserID").toString()),ord.getSymbol(),
                    Double.parseDouble(record.get("Price").toString()),Integer.parseInt(record.get("Remainder").toString()));

        }
    }


    /**
     * processing a ask MKT order
     * @param ord
     */
    public void processingAskMKT(Order ord){
        //get orderid,userid,ask price,remainder
        Map<Integer, Map<String,Object>>  bidMap = this.getDaoManager().getOrderBookDAO().getOrderBookBidBySymbol(ord.getSymbol());
        int askRemainder = ord.getQty();
        for(Map<String,Object> record: bidMap.values()) {
            if(Integer.parseInt(record.get("remainder").toString()) > askRemainder){
                try {
                    //update the seller's remainder value
                    this.getDaoManager().getOrderDAO().updateRemainderByOrderId("BUY",
                            Integer.parseInt(record.get("remainder").toString())-askRemainder,
                            Integer.parseInt(record.get("OrderID").toString()));

                    //update the buyer's remainder value
                    this.getDaoManager().getOrderDAO().updateRemainderByOrderId("SELL",
                            0, ord.getOrderID());

                    //made a deal ,update
                    this.getDaoManager().getOrderDAO().addMathchedOrder(ord.getOrderID(),Integer.parseInt(record.get("OrderID").toString()),
                            ord.getUserID(),Integer.parseInt(record.get("UserID").toString()),ord.getSymbol(),
                            Double.parseDouble(record.get("Price").toString()),askRemainder);
                    System.out.println("new order filled");
                    break;
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            this.getDaoManager().getOrderDAO().updateRemainderByOrderId("BUY",
                    0, Integer.parseInt(record.get("OrderID").toString()));
            askRemainder = askRemainder- Integer.parseInt(record.get("remainder").toString());
            this.getDaoManager().getOrderDAO().updateRemainderByOrderId(ord.getBoS(),askRemainder,ord.getOrderID());
            this.getDaoManager().getOrderDAO().addMathchedOrder(ord.getOrderID(),Integer.parseInt(record.get("OrderID").toString()),
                    ord.getUserID(),Integer.parseInt(record.get("UserID").toString()),ord.getSymbol(),
                    Double.parseDouble(record.get("Price").toString()),Integer.parseInt(record.get("Remainder").toString()));

        }
    }
}
