package com.example.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.UserDto;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
    
    @GetMapping("/hello")
    public String getHello(){
        log.info("[UserController][getHello]Start!!");
        return "Hello World!";
    }

    @PostMapping("/join/novalid")
    public String getJoinNoValid(@RequestBody UserDto dto){
        log.info("[UserController][getJoinNoValid]Start!!");
        log.info("dto: "+ dto.toString());
        
        return "가입 완료 without Validation";
    }

    @PostMapping("/join/valid")
    public String getJoinValid(@Valid @RequestBody UserDto dto){        
        log.info("[UserController][getJoinValid]Start!!");
        log.info("dto: "+ dto.toString());

        return "가입 완료 with Validation";
    }
}
