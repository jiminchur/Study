package com.example.basic.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.entity.UserEntity;
import com.example.basic.service.UserService;

@RestController
@RequestMapping("/ver1/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserEntity> selecUserAll(){
        return userService.selectUserAll();
    }
    @GetMapping("/{userAge}/{userHobby}/{userName}")
    public List<UserEntity> selectUserFilter(
        @ModelAttribute UserEntity user) {

        return userService.selectUserFilter(user);
    }
}
