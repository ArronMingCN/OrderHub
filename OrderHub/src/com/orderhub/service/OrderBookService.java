package com.orderhub.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderBookService extends BaseServicce {

    public Map<Integer, Map<String,Object>> getOrderBookBidView(String symbol){
        return this.getDaoManager().getOrderBookDAO().getOrderBookBidBySymbol(symbol);

    }
    public Map<Integer, Map<String,Object>> getOrderBookAskView(String symbol){
        return this.getDaoManager().getOrderBookDAO().getOrderBookAskBySymbol(symbol);
    }

    public Object[] getBestAskBySymbol(String symbol){
        return this.getDaoManager().getOrderBookDAO().getBestAskBySymbol(symbol);
    }
    public Object[] getBestBidBySymbol(String symbol){
        return this.getDaoManager().getOrderBookDAO().getBestBidBySymbol(symbol);
    }
}
