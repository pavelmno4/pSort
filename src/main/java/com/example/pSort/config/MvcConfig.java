package com.example.pSort.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");      //Spring предоставляет нам реализацию
                                                                                //формы авторизации
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {         //Где брать статические ресурсы
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
