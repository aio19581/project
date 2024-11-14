package com.example.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

    // WebMvcConfigurer의 추상메서드를 재정의
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //모든 URL에 대해 "/ws" 연결을 허용
                .allowedOrigins("*") //모든 도메인 허용
                .allowedMethods("GET","POST", "PUT", "DELETE") //허용 메소드 지정
                .allowedHeaders("*"); //모든 헤더 허용
    }
}
