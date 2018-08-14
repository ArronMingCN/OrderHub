package com.orderhub.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginService extends  BaseServicce {


    public boolean getUserLoginResult(String hash){
      if(this.getDaoManager().getUserDao().getUserHash(hash) != null){
          return true;
      }
      else
          return false;
    }

    public void register(String userID,String hash){
        this.getDaoManager().getUserDao().userRegister(userID,hash);
    }




}
