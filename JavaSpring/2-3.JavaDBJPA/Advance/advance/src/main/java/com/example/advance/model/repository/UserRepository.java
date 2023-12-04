package com.example.advance.model.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.advance.model.dto.UserDto;

import java.util.List;


public interface UserRepository  extends JpaRepository<UserDto,Long>{
    
    // 사용자 쿼리문 이용!!!
    @Query(value="select user_name from customer where id= :userId", nativeQuery= true)
    public String getUserNameById(@Param("userId") Long userId);

    // JPA Query Method!!
    // userName으로 시작하는 모든 이름들을 조회!!!
    public List<UserDto> findByUserNameStartingWith(String firstName);
}