package com.orderhub.dao;

import com.orderhub.entity.Order;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.SQLException;

@Service
public class OrderDAO extends BaseDAO{

    public Integer addNewMKTOrder(Order ord){
        String tableName=null;
        if(ord.getBoS()=="BUY"){
            tableName="bidorders";
        }else {
            tableName="askorders";
        }
        String sql = "insert into " +tableName+
                "(UserID,Symbol,OrderType,Status,Qty,Remainder,FOK) " +
                "values(?,?,?,?,?,?,?)";
        try {
            getQueryRunner().update(sql,ord.getUserID(),ord.getSymbol(),
                    ord.getOrderType(),ord.getStatus(),ord.getQty(),ord.getQty(),ord.getFOK());
            BigInteger id = getQueryRunner().query("SELECT LAST_INSERT_ID()",new ScalarHandler<BigInteger>());
            return id.intValue();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }


    /**
     * update the value of remainder by orderid
     * @param askOrBid
     * @param remainder
     * @param orderId
     * @return
     */
    public boolean updateRemainderByOrderId(String askOrBid,int remainder,int orderId){
        String tableName=null;
        if(askOrBid=="BUY"){
            tableName="bidorders";
        }else {
            tableName="askorders";
        }

        String sql1 = "update "+tableName+
                " set remainder=? where orderid=?";
        String sql2 =  "update "+tableName+
                " set remainder=?,status=2 where orderid=?";
        try {
            if(remainder==0){
                getQueryRunner().update(sql2,remainder,orderId);
            }
            else {
                getQueryRunner().update(sql1,remainder,orderId);
            }
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * add a new matched order into the matched table
     * @param orderid1
     * @param orderid2
     * @param userid1
     * @param userid2
     * @param symbol
     * @param price
     * @param qty
     * @return
     */
    public boolean addMathchedOrder(int orderid1,int orderid2,int userid1,int userid2,String symbol,double price,int qty){
        String sql = "insert into matchedorders" +
                "(OrderID1,OrderID2,UserID1,UserID2,Symbol,Price,Qty) " +
                "values(?,?,?,?,?,?,?)";
        try {
            getQueryRunner().update(sql,orderid1,orderid2,userid1,userid2,symbol,price,qty);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public Integer addNewLMTOrder(Order ord){
        String orderName = ord.getOrderTableName();
        String sql = "insert into " +orderName+
                "(UserID,Symbol,OrderType,Status,Qty,Remainder,price,FOK) " +
                "values(?,?,?,?,?,?,?,?)";
        try {
            getQueryRunner().update(sql,ord.getUserID(),ord.getSymbol(),
                    ord.getOrderType(),ord.getStatus(),ord.getQty(),ord.getQty(),ord.getPrice(),ord.getFOK());
            BigInteger id = getQueryRunner().query("SELECT LAST_INSERT_ID()",new ScalarHandler<BigInteger>());
            return id.intValue();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return -1;
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
