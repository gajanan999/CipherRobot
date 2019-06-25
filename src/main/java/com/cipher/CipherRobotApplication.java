package com.cipher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CipherRobotApplication extends SpringBootServletInitializer implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(CipherRobotApplication.class, args);
	}
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(CipherRobotApplication.class);
	    }

	   @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        System.out.println(">=== Inside Cors Orgin Mapping addCorsMappings ===>");
	        registry.addMapping("/api/**")
	          .allowedOrigins("*")
	          .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
	          .allowedHeaders("*")
	          .allowCredentials(true)
	          .maxAge(4800);
	    }


}
