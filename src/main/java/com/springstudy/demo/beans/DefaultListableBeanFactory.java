package com.springstudy.demo.beans;

public class DefaultListableBeanFactory extends AbstractBeanFactory implements ListableBeanFactory, BeanDefinitionRegistry {
    @Override
    public <T> T getBean(String name, Class<T> type) {
        return super.getBean(name, type);
    }

    @Override
    public Object getBean(String name) {
        return super.getBean(name);
    }

    @Override
    public boolean containsBeanDefinition(String name) {
        return super.containsBeanDefinition(name);
    }

    @Override
    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(String[]::new);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanDefinition.getBeanClassName(), beanDefinition);
    }
}
