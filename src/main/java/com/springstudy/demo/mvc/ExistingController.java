package com.springstudy.demo.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/existing")
public class ExistingController {
    @GetMapping
    public String hello(){
        log.info("hello is called");

        return "hello is called";
    }

}
