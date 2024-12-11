package com.example.WebSample.config;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public FilterRegistrationBean loggingFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LogFilter());
        filterFilterRegistrationBean.setOrder(1);
        filterFilterRegistrationBean.addUrlPatterns("/*");

        return filterFilterRegistrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) { // WebMvcConfigurer 를 통해 등록
        // 인터셉터 추가하기
        registry.addInterceptor(new LogInterceptor())
                .order(1) // 순서가 첫번째고
                .addPathPatterns("/**") // 어떤 인터셉터를 추가할지
                .excludePathPatterns("/css/*", "/images/*"); // 어떤 인터셉터를 뺄지 (보통 정적 파일들을 인터셉터를 탈 필요가 x)


    }
}
