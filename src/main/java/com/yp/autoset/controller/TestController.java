package com.yp.autoset.controller;

import com.yp.autoset.annotation.AutoSet;
import com.yp.autoset.annotation.Trainsaction;
import com.yp.autoset.annotation.Yinpeng;
import com.yp.autoset.invocation.CglibProxy;
import com.yp.autoset.mapper.UserMapper;
import com.yp.autoset.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Yinpeng
@RestController
public class TestController {

    @AutoSet
    private TestService testService;

    @Autowired
    private UserMapper userMapper ;


    public String sayHello(String name){
        System.out.println("====" + testService.sayHello(name) + "====");
        String s = testService.sayHello(name);
        return s;
    }

    @RequestMapping("/sayHello")
    @Trainsaction
    public String sayYes(String name, int age){
        System.out.println("name="+ name +" and age = " + age+ "======say yes=======");
//        System.out.println(testService.sayHello(name));
        String s= userMapper.getUserName(1);
        return s;
    }

//    public static void main(String[] args) {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(TestController.class);
//        enhancer.setCallback(new CglibProxy());
//        TestController target = (TestController) enhancer.create();
//        target.sayYes("yp", 10);
//        System.out.println("proxy class name:" + target.getClass().getName());
//    }
}
