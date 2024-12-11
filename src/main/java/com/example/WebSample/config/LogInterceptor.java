package com.example.WebSample.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        // 핸들러가 핸들링하기 전 처리하는 부분
        log.info("preHandle LogInterceptor  :" +  Thread.currentThread());
        log.info("preHandle handler : " + handler);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 핸들러가 핸들링을 정상적으로 처리하고 나가는 길에 처리
        log.info("postHandle LogInterceptor  :" +  Thread.currentThread());
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        // 핸들러가 핸들링을 정상적으로 처리하거나 실패해도 무조건 나가는 길에 처리
        log.info("afterCompletion LogInterceptor  :" +  Thread.currentThread());

        if (ex != null){ // 핸들러 처리 중 exception 발생한 경우
            log.error("afterCompletion exception : " + ex.getMessage());
        }
    }
}
