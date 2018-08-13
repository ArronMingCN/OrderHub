package com.orderhub.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("daoManager")
public class DAOManager {
    @Autowired
    private TestDAO testDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderBookDAO orderBookDAO;

    public TestDAO getTestDAO(){return testDAO;}

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public OrderBookDAO getOrderBookDAO() {
        return orderBookDAO;
    }
}
