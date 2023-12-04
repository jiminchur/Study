package com.example.advance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.advance.model.dto.UserDto;
import com.example.advance.service.UserService;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/ver2/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDto getDtoById(@PathVariable Long id){
        log.info("[UserController][getDtoById] Start!!");
        
        // 검증로직
        if(id == 0){
            log.error("[UserController][getDtoById] Error!!");
            return new UserDto();
        }
        
        //검증로직 통과한 경우 비지니스 로직 실행!
        return userService.getDtoById(id);
    }
    
    @GetMapping("/username/{useId}")
    public String getUserNamebyId(@PathVariable Long useId){
        return userService.getUserNameById(useId);
    }

    @GetMapping("/find/firstname/{firstName}")
    public List<UserDto> findByUserNameStartingWith(String firstName){
        return userService.findByUserNameStartingWith(firstName);
    }

    @PostMapping("/insert")
    public void insertDto(@RequestBody UserDto dto){
        log.info("[UserController][insertDto] Start!!");
        userService.insertDto(dto);
    }


}
