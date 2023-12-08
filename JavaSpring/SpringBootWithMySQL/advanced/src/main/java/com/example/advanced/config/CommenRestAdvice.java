package com.example.advanced.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CommenRestAdvice {
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String,Object>> defaultExceptionHandler(Exception e){
        log.info("[CommenRestAdvice][defaultExceptionHandler] Start!!");
        log.info("exception message"+e.getMessage());

        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Map<String,Object> error_msg = new HashMap<>();
        error_msg.put("message", "Sorry,please try again!!");
        error_msg.put("exception message", e.getMessage());

        return new ResponseEntity<>(error_msg,headers,status);
    }
}
