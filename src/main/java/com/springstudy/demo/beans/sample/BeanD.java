package com.springstudy.demo.beans.sample;

import com.springstudy.demo.beans.InitializingBean;

public class BeanD implements InitializingBean {
    public long createdAt;

    @Override
    public void afterPropertiesSet() {
        createdAt = System.currentTimeMillis();
        System.out.println(getClass().getName() + " is created at " + createdAt);
    }
}
