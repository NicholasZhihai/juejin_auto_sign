package com.example.mytestpro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Autowired
    private WebIntercept webIntercept;
    @Override


    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webIntercept)
        .addPathPatterns("/**");
    }
}
