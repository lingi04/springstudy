package com.springstudy.demo.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.AbstractDetectingUrlHandlerMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CustomHandlerMapping extends AbstractDetectingUrlHandlerMapping {
    public CustomHandlerMapping(){
        logger.info("=======================================");
        logger.info("= CustomHandlerMapping is Initialized =");
        logger.info("=======================================");
    }
    /**
     * Checks name and aliases of the given bean for URLs, starting with "/".
     */
    @Override
    protected String[] determineUrlsForHandler(String beanName) {
        List<String> urls = new ArrayList<>();
        if (beanName.startsWith("/")) {
            urls.add(beanName);
        }
        String[] aliases = obtainApplicationContext().getAliases(beanName);
        for (String alias : aliases) {
            if (alias.startsWith("/")) {
                urls.add(alias);
            }
        }
        return StringUtils.toStringArray(urls);
    }

}
