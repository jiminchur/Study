package com.example.advanced.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "todo")
@Entity(name = "TodoEntity")
public class TodoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // 아이디

    @Column(unique = true)
    private String name;    // 할일 이름
    private Boolean status; // 할일에 대한 상태값: true(완료)/false(비완료)

    private int progressPercentage; // 할일에 대한 진행률: 진행률이 100%면, status값이 true
    private Date duDate;            // 할일의 마감일 (마감일이 지나면, status & progressPercentage 수정 불가!!)
}
