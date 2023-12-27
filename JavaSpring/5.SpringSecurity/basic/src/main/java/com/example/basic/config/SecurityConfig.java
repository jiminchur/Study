package com.example.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration          // 스프링 설정 객체야
@EnableWebSecurity      // 스프링 설정 중에서 security
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true) 
//@controller의 method(servlet)에서
//해당 어노테이션 활성화 -> @Secured,@PreAuthorize
public class SecurityConfig {
    
    @Bean //해당 메서드의 리턴되는 오브젝트(암호화 객체)를 IoC로 등록
    public BCryptPasswordEncoder encodePwd(){
        
        return new BCryptPasswordEncoder();
    }

    // 인증&인가
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http.csrf(AbstractHttpConfigurer::disable); // 개발용
        http
            .authorizeHttpRequests(
                
            );
        return http.build();
    }







}
