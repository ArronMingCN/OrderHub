package com.orderhub.service;

import com.orderhub.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseServicce {


    /**
     * adding a new  market order
     * @param ord
     * @return
     */
    public boolean placeANewMKTOrder(Order ord){
        return getDaoManager().getOrderDAO().addNewMKTOrder(ord);
    }

    public boolean placeNewLMTOrder(Order ord){
        return getDaoManager().getOrderDAO().addNewLMTOrder(ord);
    }

    public int OrderProcessing(Order ord){
        return getDaoManager().getOrderDAO().isOrderMatched(ord);
    }




    /**
     * adding a new ask order
     * @param ord
     * @return
     */
    public boolean placeANewAskOrder(Order ord){
        return false;
    }
}
