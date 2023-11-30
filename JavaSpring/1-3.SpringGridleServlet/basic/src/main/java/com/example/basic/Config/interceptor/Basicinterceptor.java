package com.example.basic.Config.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Basicinterceptor implements HandlerInterceptor{

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {  // @Nullable Exception ex 오류가 나면 오류값이 나타나고 아니면 null
                                                        // 오류창이 뜨도록 하는 작업도 여기서 이뤄진다.
        // TODO Auto-generated method stub
        log.info("[HandlerInterceptor][afterCompletion] Start!!");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception { // 화면veiw까지 작업한뒤에 더필요한건없니~?
        // TODO Auto-generated method stub
        log.info("[HandlerInterceptor][postHandle] Start!!");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
        log.info("[HandlerInterceptor][preHandle] Start!!");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
    
    
}
