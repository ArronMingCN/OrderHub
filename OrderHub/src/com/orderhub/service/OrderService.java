package com.orderhub.service;

import com.orderhub.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseServicce {
    /**
     * adding a new bid order
     * @param ord
     * @return
     */
    public boolean placeANewBidOrder(Order ord){
        return false;
    }

    public boolean placeANewAskOrder(Order ord){
        return false;
    }
}
