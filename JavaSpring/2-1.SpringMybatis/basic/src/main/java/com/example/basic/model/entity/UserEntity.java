package com.example.basic.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {
    
    private int userId;
    private String userName;
    private int userAge;
    private String userHobby;
    
}
