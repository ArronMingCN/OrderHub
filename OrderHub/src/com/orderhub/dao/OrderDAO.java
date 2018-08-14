package com.orderhub.dao;

import com.orderhub.entity.Order;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class OrderDAO extends BaseDAO{

    public boolean addNewMKTOrder(Order ord){
        String ordername=null;
        if(ord.getBoS()=="BUY"){
            ordername="bidorders";
        }else {
            ordername="askorders";
        }
        String sql = "insert into " +ordername+
                "(UserID,Symbol,OrderType,Status,Qty,Remainder,FOK) " +
                "values(?,?,?,?,?,?,?)";
        try {
            getQueryRunner().update(sql,ord.getUserID(),ord.getSymbol(),
                    ord.getOrderType(),ord.getStatus(),ord.getQty(),ord.getQty(),ord.getFOK());
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean wa6ddNewLMTOrder(Order ord){
        String orderName = ord.getOrderTableName();
        String sql = "insert into " +orderName+
                "(UserID,Symbol,OrderType,Status,Qty,Remainder,price,FOK) " +
                "values(?,?,?,?,?,?,?,?)";
        try {
            getQueryRunner().update(sql,ord.getUserID(),ord.getSymbol(),
                    ord.getOrderType(),ord.getStatus(),ord.getQty(),ord.getQty(),ord.getPrice(),ord.getFOK());
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    //0-processing,1-matched,2-canceled
    public int isOrderMatched(Order ord){
        String orderName = ord.getOrderTableName();
        //find if there is a same price in bid/ask table.
        String orderCheck = "select * from "+orderName+"where price = "+ord.getPrice();
        try{
            Object[] result = getQueryRunner().query(orderCheck,new ArrayHandler());
            for (Object obj : result) {
                System.out.println(obj);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }



        return 0;
    }




}
