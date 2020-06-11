package com.springstudy.demo.beans;

public class DefaultApplicationContext extends AbstractBeanFactory implements ListableBeanFactory, BeanDefinitionRegistry  {
    private final DefaultListableBeanFactory beanFactory;

    public DefaultApplicationContext() {
        this.beanFactory = new DefaultListableBeanFactory();
    }

    public DefaultApplicationContext(BeanFactory parentBeanFactory){
        this();
        this.parentBeanFactory = parentBeanFactory;
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return false;
    }

    @Override
    public int getBeanDefinitionCount() {
        return beanFactory.getBeanDefinitionCount();
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanFactory.getBeanDefinitionNames();
    }

    @Override
    public <T> T getBean(String name, Class<T> type) {
        return beanFactory.getBean(name, type);
    }

    @Override
    public Object getBean(String name) {
        return beanFactory.getBean(name);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        beanFactory.registerBeanDefinition(beanDefinition);
    }
}
