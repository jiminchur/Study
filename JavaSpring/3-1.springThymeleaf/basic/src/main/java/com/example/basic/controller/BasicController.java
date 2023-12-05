package com.example.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.basic.model.UserDto;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/thymeleaf")
public class BasicController {
    
    @GetMapping("/greeting")
    public String greeting(
        @RequestParam(name = "name",required = false,defaultValue = "World")
        String name, Model model){
        
        log.info("[BasicController][greeting] Start!!");
        log.info("name: "+name);
        
        model.addAttribute("key", name);
        return "greeting";
    }

    @GetMapping("/utext")
    public String utext(Model model){

        model.addAttribute("tag", "<h2>태그 전달하기</h2>");
        return "utext";
    }

    @GetMapping("/pv/{num}")
    public String pv1(Model model, @PathVariable int num){
        
        model.addAttribute("num", num);
        return "thymeleaf/pv1";

    }
    @GetMapping("/form")
    public String getform(Model model,@RequestParam(name = "name", required = false, defaultValue = "World" ) String data1){

        model.addAttribute("data1", data1);
        return "thymeleaf/form";
    }

    @PostMapping("/form")
    public String postform(Model model, @RequestParam("data1") String data1){

        model.addAttribute("data1", data1);
        return "thymeleaf/form";
    }

    @GetMapping("/modelAndView")
    public ModelAndView modelAndView(ModelAndView modelAndView){
        
        // 데이터 추가
        modelAndView.addObject("name", "지민철");
        modelAndView.addObject("age", 25);
        

        // 화면 추가
        modelAndView.setViewName("thymeleaf/modelAndView");
        return modelAndView;
    }

    @GetMapping("/multiform")
    public ModelAndView multiForm(ModelAndView mav){
        
        mav.addObject("msg", "여러 개 input값 입력 후 전송버튼 클릭");
        mav.setViewName("thymeleaf/multiform");
        return mav;
    }


    @PostMapping("/multi")
    public ModelAndView multiSend(ModelAndView mav, @ModelAttribute UserDto dto){
        
        mav.addObject("msg", "dto를 사용하였습니다.");
        mav.addObject("userDto", dto);
        mav.setViewName("thymeleaf/multiSend");
        return mav;
    }
}
    



