package com.springstudy.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.HandlerMapping;

import java.util.HashMap;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    ApplicationContext applicationContext;
    @Test
    void contextLoads() {
        Object o = applicationContext.getBean(HandlerMapping.class);
        HashMap<String, HandlerMapping> map = (HashMap<String, HandlerMapping>)applicationContext.getBeansOfType(HandlerMapping.class);

//        for (Map.Entry<String, HandlerMapping> e :
//            map.entrySet()) {
//
//            System.out.println(e.getKey());
//            System.out.println(e.getValue());
//        }
        System.out.println("contextLoads");
    }

}
