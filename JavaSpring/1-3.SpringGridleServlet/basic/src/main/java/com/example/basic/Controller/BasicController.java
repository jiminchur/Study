package com.example.basic.Controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BasicController {

    @GetMapping("/hello")
    public String gethello(){
        log.info("[BasicController][gethello] Start!!");
        return "hello world";
    }
    
    @GetMapping("/query")
    public String getquery(
        @RequestParam Map<String,Object> params ){
        log.info("[BasicController][getquery] Start!!");
        String msg = "";
        for(String key:params.keySet()){
            msg = msg + (String)params.get(key);
        }
        return msg;
    }
    

    
}
