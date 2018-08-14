package com.orderhub.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class MatchUtil extends BaseServicce {

    public String encrypByMd5(String string){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(string.getBytes());//update处理
            byte [] encryContext = md.digest();//调用该方法完成计算

            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < encryContext.length; offset++) {//做相应的转化（十六进制）
                i = encryContext[offset];
                if (i < 0) i += 256;
                if (i < 16) buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
            //System.out.println("32result: " + buf.toString());// 32位的加密
          //  System.out.println("16result: " + buf.toString().substring(8, 24));// 16位的加密

        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }



}
