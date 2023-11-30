package com.example.basic.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.BasicDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class basiccotroller {

    @GetMapping("/hello")
    public String getHello(){
        String msg = "Hello World project";

        return msg;
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String gethello1(){
        String msg = "Hello World project";
        log.info("msg :" + msg);
        return msg;
    }
    @GetMapping("/variable/{param}")
    public String gethello2(@PathVariable String param){
        log.info("url으로 부터 param받았어!! "+param);
        return param;
    }

    @GetMapping("/variable/{param}/{param2}")
    public String gethello3(@PathVariable String param,@PathVariable String param2){
        log.info("url으로 부터 param받았어!! "+param);
        return param2;
    }
    @GetMapping("/variable4/{param}")
    public String gethello4(@PathVariable("param") String name){
        log.info("url으로 부터 name받았어!! "+name);
        return name;
    }    
    @GetMapping("/logging")
    public String getLogging(){
        log.info("logging에 들어왔어");

        return "logging";
    }
    
    //  query?key=helloworld
    @GetMapping("/query")
    public String getQuery(@RequestParam String key){
        log.info("어서와 query는 처음이지?!");
        return key;
    }
    @GetMapping("/query2")
    public String getQuery2(
        @RequestParam String key1,
        @RequestParam String key2,
        @RequestParam String key3
        ){
        log.info("어서와 다중query는 처음이지?!");
        return key1 +key2 +key3;
    }
    //  query3?key1=abc&key2=abc&key3=abc&key4=abc&key5=abc&key6=abc
    @GetMapping("/query3")
    public String getQuery3(
        @RequestParam Map<String, Object> params){
        log.info("어서와 다중query는 처음이지?!");
        String msg = "";
        
        for(String key:params.keySet()){
            msg = msg + (String)params.get(key);
        }
        return msg;
    }
    // dto1?name=name1&email=email1
    @GetMapping("/dto1")
    public String getDto1(@ModelAttribute BasicDto dto){
        return dto.toString();
    }
    
}
    