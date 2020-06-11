package com.springstudy.demo.beans;

import com.springstudy.demo.beans.sample.BeanC;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanFactory implements ConfigurableBeanFactory {
    BeanFactory parentBeanFactory;

    Map<String, Object> beanMap = new HashMap<>();
    Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public <T> T getBean(String name, Class<T> type) {
        return (T) getBean(name);
    }

    @Override
    public Object getBean(String name) {
        if (!beanMap.containsKey(name)) {
            if (parentBeanFactory != null && isParentContainsBeanDefinition(name)) {
                return parentBeanFactory.getBean(name);
            }
            beanMap.put(name, generateBean(name));
        }

        return beanMap.get(name);
    }

    private Object generateBean(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        Object object = null;

        try {
            object = beanDefinition
                .getClazz()
                .getDeclaredConstructor()
                .newInstance();

            setProperties(object, beanDefinition);

            initObject(object);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return object;
    }

    private void initObject(Object object) {
        if (object instanceof InitializingBean) {
            InitializingBean iBean = (InitializingBean) object;
            iBean.afterPropertiesSet();
        }
        if (object instanceof BeanC) {
            InitializingBean iBean = (InitializingBean) object;
            iBean.afterPropertiesSet();
        }
    }

    private void setProperties(Object object, BeanDefinition beanDefinition) {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues()) {
            Field field = null;
            try {
                field = beanDefinition.getClazz().getDeclaredField(propertyValue.getName());
            } catch (NoSuchFieldException e) {
                // ToDo printStackTrace -> get message
                e.printStackTrace();
            }

            String propertyName = propertyValue.getName();

            try {
                Method method =
                    beanDefinition
                        .getClazz()
                        .getMethod(
                            "set"
                                + propertyName.substring(0, 1).toUpperCase()
                                + propertyName.substring(1)
                            , new Class[]{field.getType()});
                try {
                    if (field.getType() == Integer.class) {
                        method.invoke(object, Integer.parseInt(propertyValue.getValue().toString()));
                    } else {
                        method.invoke(object, propertyValue.getValue());
                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isParentContainsBeanDefinition(String name) {
        if (parentBeanFactory instanceof AbstractBeanFactory) {
            return ((AbstractBeanFactory) parentBeanFactory).containsBeanDefinition(name);
        } else {
            return false;
        }
    }

    public boolean containsBeanDefinition(String name) {
        return beanDefinitionMap.containsKey(name);
    }
}
