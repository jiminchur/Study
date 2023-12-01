package com.example.basic.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.basic.model.dto.BlogDto;


@Mapper
public interface BlogMapper {

    public List<BlogDto> selectAll();
    public void insertBlog(BlogDto dto);
    public void updateBlog(BlogDto dto);
    public void deleteBlog(@Param("blogNumber") int blogNumber);
}