package com.springstudy.demo.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@CustomRestController
@RequestMapping("/custom")
public class ExampleController {
    @GetMapping
    public String hello(){
        log.info("Custom controller adapter is called");
        return "Custom controller adapter is called";
    }
}
