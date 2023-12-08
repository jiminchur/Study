package com.example.advanced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.advanced.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ver1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;
    
    // @GetMapping("all")
    // public String selectAll(Model model){

    //     model.addAttribute("todolist",todoService.selectAll());
    //     return "todo";
    // }
}
