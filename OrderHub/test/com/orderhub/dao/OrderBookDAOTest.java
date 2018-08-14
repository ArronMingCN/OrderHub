package com.orderhub.dao;

import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderBookDAOTest{

    @Autowired
    private OrderBookDAO orderBookDAO;

    @Test
    void getOrderBookBidBySymbol() {


    }

    @Test
    void getOrderBookAskBySymbol() {
    }

    @Test
    void getBestAskBySymbol() {
    }

    @Test
    void getBestBidBySymbol() {
    }

    @Test
    void getAllLevel1() {
        String bidSql = "select DISTINCT(Symbol) from bidorderbook";
        QueryRunner queryRunner = mock(QueryRunner.class);
        List<String> l =new ArrayList<>();
        l.add("symbol");
        when(queryRunner.query(bidSql)).thenReturn(l);
        JSONObject jsonObject = orderBookDAO.getAllLevel1();
        assertEquals(jsonObject.get("symbol"), "data");

    }
}