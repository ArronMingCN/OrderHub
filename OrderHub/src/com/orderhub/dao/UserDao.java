package com.orderhub.dao;

import com.orderhub.entity.User;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Service
public class UserDao extends BaseDAO {

    public User getUserHash(String hash){
        User user = new User();
        String sql = "select id from user where hashcode =?";
        try{
            String result = getQueryRunner().query(sql,hash,new ScalarHandler<String>());
            if(result != ""){
                user.setUserID(Integer.parseInt(result));
                return user;
            }
            else
                return user;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;

    }

    public void userRegister(String userID,String hash){
        String regHashSql = "update user set hashcode = ? where id =?";
        try{
            getQueryRunner().update(regHashSql,hash,userID);
        }catch (SQLException e){
            e.printStackTrace();
        }

    };





}
