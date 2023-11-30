package com.example.basic.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
public class BasicDto {
    
    private String name;
    private String email;

    // public BasicDto(){} // 기본생성함수
    // public BasicDto(String name,String email){ // 일반생성함수
    //     this.name = name;
    //     this.email = email;
    // }


    // // 우클릭 source action에서
    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public String getEmail() {
    //     return email;
    // }
    // public void setEmail(String email) {
    //     this.email = email;
    // }
    // @Override
    // public String toString() {
    //     return "BasicDto [name=" + name + ", email=" + email + "]";
    // }

    // public String getName(){
    //     return this.name;
    // }
    // public void setName(String name){
    //     this.name = name;
    // }
    // public String getEmail(){
    //     return this.email;
    // }
    // public void setEmail(String email){
    //     this.email = email;
    // }
    // // dto1?name=name1&email=email1
    // @GetMapping("/dto1")
    // public String getDto1(@ModelAttribute BasicDto dto){
    //     return dto.toString();
    // }
    

}
