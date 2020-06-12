package com.springstudy.demo.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import java.lang.reflect.Method;

@Slf4j
//@Component
public class CustomHandlerMapping extends RequestMappingInfoHandlerMapping {
    public CustomHandlerMapping(){
        log.info("=======================================");
        log.info("= CustomHandlerMapping is Initialized =");
        log.info("=======================================");
    }

    @Override
    protected boolean isHandler(Class<?> beanType) {
        return false;
    }

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        return null;
    }

//    /**
//     * Checks name and aliases of the given bean for URLs, starting with "/".
//     */
//    @Override
//    protected String[] determineUrlsForHandler(String beanName) {
//        List<String> urls = new ArrayList<>();
//        if (beanName.startsWith("/")) {
//            urls.add(beanName);
//        }
//        String[] aliases = obtainApplicationContext().getAliases(beanName);
//        for (String alias : aliases) {
//            if (alias.startsWith("/")) {
//                urls.add(alias);
//            }
//        }
//        return StringUtils.toStringArray(urls);
//    }

}
