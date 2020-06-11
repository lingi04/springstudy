package com.springstudy.demo.beans;

public interface BeanFactory {
    <T> T getBean(String name, Class<T> type);
    Object getBean(String name);
}
