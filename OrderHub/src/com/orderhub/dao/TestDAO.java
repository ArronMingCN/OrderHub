package com.orderhub.dao;


import com.orderhub.dao.BaseDAO;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class TestDAO extends BaseDAO {

    public void test() {

        //ResultSetHandler<List<String>> rsh = new BeanHandler<List<String>>(String.class);

        try {
            String sql="select nam from test where id=?";
            String a = (String)getQueryRunner().query(sql,1,new ScalarHandler<String>());

            System.out.println("result is ---"+a);
        }catch (SQLException e){
            System.out.println(e);

        }
    }
}
