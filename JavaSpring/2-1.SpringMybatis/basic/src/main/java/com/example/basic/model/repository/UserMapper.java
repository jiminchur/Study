package com.example.basic.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.basic.model.entity.UserEntity;

@Mapper
public interface UserMapper {
    List<UserEntity> selectUserAll();
    List<UserEntity> selectUserFilter(
        @Param("userAge") int userAge, 
        @Param("userHobby") String userHobby,
        @Param("userName") String userName
    );
}
