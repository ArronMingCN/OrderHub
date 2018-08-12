package com.orderhub.dao;
 import java.sql.Connection;
 import java.sql.SQLException;
 import javax.sql.DataSource;
 import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseDAO {
    @Autowired
    protected DataSource dataSource=null;

    private QueryRunner qr=null;
    public Connection getConnection(){

        try{
            return dataSource.getConnection();
        }catch(SQLException e){
            System.out.println("get connection failed:"+e);
            return null;
        }
    }

    public QueryRunner getQueryRunner(){
        if(qr==null){
            qr=new QueryRunner(dataSource);
        }
        return qr;
    }
}
