package com.orderhub.dao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

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

    public Object[] getBestAskBySymbol(String symbol){
        String sql = "select * from askorderbook where symbol=? order by price asc";
        try {
            Object[] rs = getQueryRunner().query(sql,symbol,new ArrayHandler());
            return rs;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public Object[] getBestBidBySymbol(String symbol){
        String sql = "select * from BidOrderBook  where symbol=? order by price desc";
        try {
            Object[] rs = getQueryRunner().query(sql,symbol,new ArrayHandler());
            return rs;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * working...
     */
    public void getAllLevel2(){
        String bidSql = "select DISTINCT(Symbol) from bidorderbook";
        String askSql = "select DISTINCT(Symbol) from bidorderbook";
        try{
            Object[] bidRS = getQueryRunner().query(bidSql,new ArrayHandler());
            Object[] askRS = getQueryRunner().query(askSql,new ArrayHandler());
            JSONArray jsonArrayBid = new JSONArray();
            JSONArray jsonArrayAsk =new JSONArray();

            for(Object b:bidRS){
                JSONObject jsonObjectBid=new JSONObject();
                Object[] temp =getBestBidBySymbol(b.toString());
                jsonObjectBid.put("key",temp[0]);
                jsonObjectBid.put("price",temp[4]);
                jsonObjectBid.put("size",temp[3]);
                jsonArrayBid.add(jsonArrayBid);
             }
            for(Object a:askRS){
                JSONObject jsonObjectAsk=new JSONObject();
                Object[] temp =getBestAskBySymbol(a.toString());
                jsonObjectAsk.put("key",temp[0]);
                jsonObjectAsk.put("price",temp[4]);
                jsonObjectAsk.put("size",temp[3]);
                jsonArrayAsk.add(jsonObjectAsk);
               }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
