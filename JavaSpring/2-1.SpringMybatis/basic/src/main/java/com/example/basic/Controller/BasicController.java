package com.example.basic.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ver1/basic")
public class BasicController {
    
    @GetMapping("/hello")
    public String gethello(){
        log.info("[BasicController][gethello] Start!!");

        return "hello world!!";
    }
}
