package com.springstudy.demo.beans;

public class BeanDefinition {
    private final String beanClassName;
    private final PropertyValues propertyValues;
    private final Class<?> clazz;

    public BeanDefinition(String beanClassName, PropertyValues propertyValues, Class<?> clazz) {
        this.beanClassName = beanClassName;
        this.propertyValues = propertyValues;
        this.clazz = clazz;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public String getBeanClassName() {
        return beanClassName;
    }
}
