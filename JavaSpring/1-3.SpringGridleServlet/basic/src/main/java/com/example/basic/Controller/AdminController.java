package com.example.basic.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin") // admin으로 시작하는 모든 요청..
public class AdminController {
    
    @GetMapping("/hello")
    public String gethello(){
        log.info("[AdminController][gethello] Start!!");

        return "Hello Admin";
    }

    @GetMapping("/world")
    public String getworld(){
        log.info("[AdminController][getworld] Start!!");

        return "Admin World";
    }
}
