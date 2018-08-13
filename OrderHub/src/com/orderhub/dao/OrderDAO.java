package com.orderhub.dao;

import com.orderhub.entity.Order;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class OrderDAO extends BaseDAO{

    public boolean addNewMKTOrder(Order ord){
        String ordername=null;
        if(ord.getBoS()=="BUY"){
            ordername="bidorders";
        }else {
            ordername="askorders";
        }
        String sql = "insert into " +ordername+
                "(UserID,Symbol,OrderType,Status,Qty,Remainder,FOK) " +
                "values(?,?,?,?,?,?,?)";
        try {
            getQueryRunner().update(sql,ord.getUserID(),ord.getSymbol(),
                    ord.getOrderType(),ord.getStatus(),ord.getQty(),ord.getQty(),ord.getFOK());
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
