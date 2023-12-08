package com.example.basic.dao;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BasicDao {
    
    public String test(){
        log.info("[BasicDao][test] Start!!");
        
        return "[BasicDao][test]정상입니다.";
    }

    public String testException() throws Exception {
        log.info("[BasicDao][testException] Start!!");
        
        throw new Exception("[BasicDao][testException] 오류입니다.");
    }
}
