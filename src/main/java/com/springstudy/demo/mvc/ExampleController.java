package com.springstudy.demo.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@CustomRestController("/")
public class ExampleController {
    @GetMapping
    public void hello(){
        log.info("hello is called");
    }

}
