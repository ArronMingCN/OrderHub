package com.orderhub.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orderhub.service.ServiceManager;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;
import com.orderhub.dao.TestDAO;

import java.io.IOException;
import java.io.PrintWriter;


public class BaseController{

    @Autowired
    private ServiceManager serviceManager;

    public ServiceManager getServiceManager() {
        return serviceManager;
    }



}
