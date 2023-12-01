package com.example.basic.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.model.dto.BlogDto;
import com.example.basic.model.repository.BlogMapper;

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;

    public List<BlogDto> selectAll() {
        return blogMapper.selectAll();
    }
    
// insert
    public void insertBlog(BlogDto dto) {
        if(dto.getBlogTitle() != null) {
            String blogTitle = dto.getBlogTitle();
            blogTitle += "^*^";
            dto.setBlogTitle(blogTitle);
        }
        blogMapper.insertBlog(dto);
    }

// update
    public void updateBlog(BlogDto dto){
        if(dto.getBlogNumber() != 0){
            blogMapper.updateBlog(dto);
        }
    }

// delete
    public void deleteBlog(int blogNumber){
        if(blogNumber != 0){
            blogMapper.deleteBlog(blogNumber);
        }
    }
}
