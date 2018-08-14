package com.orderhub.dao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.*;

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
        String sql = "select * from askorderbook where symbol=? order by price asc LIMIT 1";
        try {
            Object[] rs = getQueryRunner().query(sql,symbol,new ArrayHandler());
            return rs;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public Object[] getBestBidBySymbol(String symbol){
        String sql = "select * from BidOrderBook  where symbol=? order by price desc LIMIT 1";
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
    public JSONObject getAllLevel1(){
        String bidSql = "select DISTINCT(Symbol) from bidorderbook";
        String askSql = "select DISTINCT(Symbol) from askorderbook";
        try{
            List<String> bidRS = getQueryRunner().query(bidSql,new ColumnListHandler<String>());
            List<String> askRS = getQueryRunner().query(askSql,new ColumnListHandler<String>());
            HashSet<String> rs= new HashSet<String>();
            for(String r:bidRS){
                rs.add(r);
            }
            for(String r:askRS){
                rs.add(r);
            }
            JSONArray jsonArray = new JSONArray();
            for(String symbol:rs){
                JSONObject jsonObject=new JSONObject();
                Object[] bid =getBestBidBySymbol(symbol);
                Object[] ask =getBestAskBySymbol(symbol);
                jsonObject.put("symbol",symbol);
                jsonObject.put("bidQty",bid[3]);
                jsonObject.put("bidPrice",ask[4]);
                jsonObject.put("askPrice",ask[4]);
                jsonObject.put("askQty",ask[3]);
                jsonArray.add(jsonObject);
             }
             JSONObject obj = new JSONObject();
            obj.put("market",jsonArray);
            return obj;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
