package com.springstudy.demo.beans.sample;

import com.springstudy.demo.beans.InitializingBean;

public class BeanE implements InitializingBean {
    public long createdAt;

    @Override
    public void afterPropertiesSet() {
        createdAt = System.currentTimeMillis();
        System.out.println(getClass().getName() + " is created at " + createdAt);
    }
}
