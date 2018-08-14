package com.orderhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceManager {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderBookService orderBookService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private MatchUtil matchUtil;

    public OrderService getOrderService() {
        return orderService;
    }

    public OrderBookService getOrderBookService() {
        return orderBookService;
    }

    public LoginService getLoginService(){return loginService;}

    public MatchUtil getMyUtil(){return matchUtil;}


}
