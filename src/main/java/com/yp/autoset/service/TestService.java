package com.yp.autoset.service;


import com.yp.autoset.annotation.Yinpeng;
import org.springframework.stereotype.Service;

@Yinpeng(value = "yp")
public class TestService {

    public String sayHello(String name){
//        userMapper.getUserName(1);
        return name;
    }

}
