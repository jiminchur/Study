package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.dto.BlogDto;
import com.example.basic.model.service.BlogService;

@RestController
@RequestMapping("/ver/blog")
public class BlogController {
    
    @Autowired
    private BlogService blogService;

    // localhost:8080/ver1/blog/all
    @GetMapping("/all")
    public List<BlogDto> selectAll(){
        return blogService.selectAll();
    }

    // localhost:8080/ver1/blog/insert
    @PostMapping("/insert")
    public String insertBlog(@RequestBody BlogDto dto){
        blogService.insertBlog(dto);

        return "upload complete!!";
    }

    // localhost:8080/ver1/blog/update
    @PostMapping("/update")
    public String updateBlog(@RequestBody BlogDto dto){
        blogService.updateBlog(dto);

        return "update complete!!";
    }

    // localhost:8080/ver1/blog/delete/4
    @GetMapping("/delete/{blogNumber}")
    public String deleteBlog(@PathVariable int blogNumber){
        blogService.deleteBlog(blogNumber);

        return "delete complete!!";
    }


}
