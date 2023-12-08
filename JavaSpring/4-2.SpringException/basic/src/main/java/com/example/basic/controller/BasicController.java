package com.example.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.service.BasicService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BasicController {
    
    @Autowired
    private BasicService basicService;

    @GetMapping("/hello/{num}")
    public String getHello(@PathVariable int num){
        log.info("[BasicController][getHello] Start!!");

        String msg = "hello world!!";
        try{
            log.info("[BasicController][getHello] try Start!!");
            
            int i = 10/num;
            log.info("[BasicController][getHello] try End!!");
        }catch(Exception e){
            log.info("[BasicController][getHello] catch Start!!");
            
            msg = e.getMessage();
        }finally{
            log.info("[BasicController][getHello] finally Start!!");
        }
        return msg;
    }

    @GetMapping("/exception1")
    public void exception1() throws Exception {
        throw new Exception("[BasicController][exception1] Error!!");
    }

    @GetMapping("/exception2")
    public String exception2(){
        log.info("[BasicController][exception2] Start!!");
        try{
            log.info("[BasicController][exception2] try Start!!");
            throw new Exception("[BasicController][exception2] Error!!");
        }catch(Exception e){
            log.info("[BasicController][exception2] catch Start!!");
        }
        return "Good moring!!";
    }
    
    public String exceptionHandler(Exception e){
        
        return "";
    }

    // 정상 테스트
    @GetMapping("/ok")
    public String ok() throws Exception {
    log.info("[BasicController][ok] Start!!");
        return basicService.test();
    }

    // 오류 테스트 
    @GetMapping("/exception/controller")
    public String exception3() throws Exception {
        log.info("[BasicController][exception3] Start!!");

        throw new Exception("[BasicController][exception3] 오류입니다.");
    }
    // service 오류 테스트
    @GetMapping("/exception/service")
    public String exception4() throws Exception {
        log.info("[BasicController][exception4] Start!!");

        return basicService.testException();
    }

    // Dao 오튜 테스트
    @GetMapping("/exception/dao")
    public String exception5() throws Exception {
        log.info("[BasicController][exception5] Start!!");

        return basicService.daoException();
    }
}

