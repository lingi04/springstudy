package com.springstudy.demo.mvc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/existing")
public class ExistingController {
    @GetMapping
    public String hello(){
        log.info("Existing controller adapter test");

        return "Existing controller adapter is called";
    }
}
