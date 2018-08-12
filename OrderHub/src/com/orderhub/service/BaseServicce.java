package com.orderhub.service;

import com.orderhub.dao.DAOManager;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServicce {
    @Autowired
    private DAOManager daoManager;

    @Autowired
    private ServiceManager serviceManager;

    public DAOManager getDaoManager() {
        return daoManager;
    }

    public ServiceManager getServiceManager() {
        return serviceManager;
    }
}
