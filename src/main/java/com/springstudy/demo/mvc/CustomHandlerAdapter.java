package com.springstudy.demo.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class CustomHandlerAdapter implements HandlerAdapter {
    private final RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    public CustomHandlerAdapter(RequestMappingHandlerAdapter requestMappingHandlerAdapter){
        this.requestMappingHandlerAdapter = requestMappingHandlerAdapter;

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
        log.info("CustomHandlerAdapter is called -supports : {}", ((HandlerMethod) handler).getBean() instanceof ExampleController);

        return (((HandlerMethod) handler).getBean() instanceof ExampleController);
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

//        Method m = ReflectionUtils.findMethod(ExampleController.class, "control", Map.class, Map.class);
//        RequiredParams requiredParams = AnnotationUtils.getAnnotation(m, RequiredParams.class);
//
//        Map<String, String> params = new HashMap<>();
//        for(String param : requiredParams.value()){
//            String value = request.getParameter(param);
//            if(value == null){
//                throw new IllegalStateException();
//            }
//            params.put(param, value);
//        }
//
//        Map<String, Object> model = new HashMap<>();
//        model.put("param",params);
//        model.put("thisIsAddedParamInCustomHandler","이게되네");
//
//        SimpleController simpleController = (SimpleController)(((HandlerMethod) handler).getBean());
//        simpleController.control(params, model);
//        return new ModelAndView("test", model);

        // Bean 등록할 때 WebApplicationContext
        return requestMappingHandlerAdapter.handle(request, response, handler);
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
