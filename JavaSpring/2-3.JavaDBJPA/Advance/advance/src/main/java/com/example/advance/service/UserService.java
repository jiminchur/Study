package com.example.advance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.advance.model.dto.UserDto;
import com.example.advance.model.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserDto getDtoById(long id){
        return userRepository.getReferenceById(id);
    }

    public void insertDto(UserDto dto){
        userRepository.save(dto);
    }

    public String getUserNameById(Long userId) {

        log.info("[UserService][getUserNameById] Start");
        return userRepository.getUserNameById(userId);
    }

    public List<UserDto> findByUserNameStartingWith(String firstName) {

        log.info("[UserService][findByUserNameStartingWith] Start");
        return userRepository.findByUserNameStartingWith(firstName);
    }

}


