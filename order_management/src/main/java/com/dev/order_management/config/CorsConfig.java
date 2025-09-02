package com.dev.order_management.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
        	
        	 @Value("${app.cors.allowed-origins}")
        	    private String[] allowedOrigins;  // will split by comma automatically
        	
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // apply to all endpoints
                        .allowedOrigins("http://localhost:5173") // dev frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // allow REST ops
                        .allowedHeaders("*"); // allow all headers
            }
        };
    }
}
