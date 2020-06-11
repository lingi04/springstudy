package com.springstudy.demo.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class CustomHandlerAdapter implements HandlerAdapter {
    public CustomHandlerAdapter(){
        log.info("=======================================");
        log.info("= CustomHandlerAdapter is Initialized =");
        log.info("=======================================");
    }
    /**
     * 이 핸들러어댑터가 지원하는 핸들러(컨트롤러) 타입인지 확인한다.
     * @param handler
     * @return
     */
    @Override
    public boolean supports(Object handler) {
        log.info("CustomHandlerAdapter is called");
        return (handler instanceof Controller);
    }

    /**
     * DispatcherServlet의 요청을 받아 컨트롤러를 실행해주는 메소드.
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    @Nullable
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {

        return ((Controller) handler).handleRequest(request, response);
    }

    /**
     * HttpServlet의 getLastModified를 지원해 주는 메소드.
     *
     * @param request
     * @param handler
     * @return
     */
    @Override
    public long getLastModified(HttpServletRequest request, Object handler) {
        return -1L;
    }
}
