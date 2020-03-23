package com.whiteboardfederal.resumaker.config;

import com.whiteboardfederal.resumaker.utils.ApiConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(ApiConstants.WEBAPP_LOCALHOST)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}