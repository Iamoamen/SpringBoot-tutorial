package com.springboot.SpringBoottutorial.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {
    @Value("${welcome.message}")
    private String welcomeMessage ;
    @GetMapping(value = "/")
    public String HelloController(){
        return welcomeMessage ;
    }
}
