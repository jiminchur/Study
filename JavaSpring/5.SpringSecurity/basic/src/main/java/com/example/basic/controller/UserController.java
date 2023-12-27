package com.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {
    

    @GetMapping("/index")
    public String index(){
        log.info("[UserController][index] Start!!");
        return "index";
    }
    @GetMapping("/logout")
    public String logout(){
        log.info("[UserController][logout] Start!!");
        return "redirect:/login";
    }
    @GetMapping("/join")
    public String joinpage(){
        log.info("[UserController][joinpage] Start!!");
        return "join";
    }
    @PostMapping("/join")
    public String join(){
        log.info("[UserController][join] Start!!");
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String loginpage(){
        log.info("[UserController][loginpage] Start!!");
        return "login";
    }

    @GetMapping("/user")
    public String user(){
        log.info("[UserController][user] Start!!");
        return "user";
    }
    @GetMapping("/admin")
    public String admin(){
        log.info("[UserController][admin] Start!!");
        return "admin";
    }
}
