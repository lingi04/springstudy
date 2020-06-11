package com.springstudy.demo.beans;

public class BeanDefinitionReader {

    private final BeanDefinitionRegistry beanDefinitionRegistry;

    public BeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void read(BeanDefinition beanDefinition) {
        beanDefinitionRegistry.registerBeanDefinition(beanDefinition);
    }
}
