package com.springstudy.demo.beans.sample;

import com.springstudy.demo.beans.InitializingBean;

public class BeanC implements InitializingBean {
    public boolean flag = false;

    @Override
    public void afterPropertiesSet() {
        flag = true;
    }
}
