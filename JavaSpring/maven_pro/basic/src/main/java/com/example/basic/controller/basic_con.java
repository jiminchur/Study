package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class basic_con {

    @GetMapping("/hello")
    public String gethello(){

        String msg = "hello world !!!!!!";

        return msg;
    }
    
}
