package com.example.SkyTravel.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    // Override the addCorsMappings method to configure CORS settings
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow cross-origin requests from any path ("/**")
        registry.addMapping("/**")

                // Replace "http://allowed-origin.com" with the domain(s) you want to allow
//                .allowedOrigins("http://allowed-origin.com")

                // Allow specific HTTP methods (GET, POST)
                .allowedMethods("GET", "POST")

                // Allow specific headers (Authorization, Content-Type)
                .allowedHeaders("Authorization", "Content-Type")

                // Allow sending credentials (e.g., cookies, authorization headers) with the request
                .allowCredentials(true)

                // Set the max age (in seconds) for how long the CORS preflight response can be cached
                .maxAge(3600);
    }
}