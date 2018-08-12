package com.orderhub.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("daoManager")
public class DAOManager {
    @Autowired
    private TestDAO testDAO;

    public TestDAO getTestDAO(){return testDAO;}
}
