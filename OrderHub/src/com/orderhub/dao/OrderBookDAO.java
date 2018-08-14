package com.orderhub.dao;

import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

@Service
public class OrderBookDAO extends BaseDAO {


    public Map<Integer,Map<String,Object> > getOrderBookBidBySymbol(String symbol){

        String sql = "select * from BidOrderBook  where symbol=? order by price desc";
        try{

            Map<Integer,Map<String,Object> > rs = getQueryRunner().query(sql,symbol,new KeyedHandler<Integer>("OrderID"));
            return rs;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public Map<Integer,Map<String,Object> > getOrderBookAskBySymbol(String symbol){

        String sql = "select * from AskOrderBook  where symbol=? order by price asc";
        try{

            Map<Integer,Map<String,Object> > rs = getQueryRunner().query(sql,symbol,new KeyedHandler<Integer>("OrderID"));
            return rs;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }



}
