package com.example.WebSample.config;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        log.info("Hello LogFilter : " + Thread.currentThread());
        // 외부 -> filter (-> 처리 ->) filter -> 외부
                           // 이 부분
        chain.doFilter(request, response);
        log.info("Bye LogFilter : " + Thread.currentThread());
    }
}
