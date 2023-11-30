package com.example.basic.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.basic.Config.interceptor.Basicinterceptor;

@Configuration // 너 실행하기전에 이거부터 보고 해줘
public class WebMvcConfig implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        // WebMvcConfigurer.super.addInterceptors(registry);

        registry.addInterceptor(new Basicinterceptor())
            .addPathPatterns("/**") // **완전한 모든
            .excludePathPatterns("/admin/**"); // admin으로 시작하는 녀석 빼고 나머지 다 적용해줘
    }
    
}
