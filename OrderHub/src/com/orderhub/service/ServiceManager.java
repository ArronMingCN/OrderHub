package com.orderhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceManager {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderBookService orderBookService;

    public OrderService getOrderService() {
        return orderService;
    }

    public OrderBookService getOrderBookService() {
        return orderBookService;
    }
}
