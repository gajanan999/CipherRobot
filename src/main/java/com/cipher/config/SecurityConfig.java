package com.cipher.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class is very important cause all the application access configuration has been written in the class
 * @author gajagaik
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${REST.USERNAME}")
	private String USERNAME;
	
	@Value("${REST.PASSWORD}")
	private String PASSWORD;

	@Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
         .csrf().disable()
         .authorizeRequests()
         .antMatchers("/h2-console/**").permitAll()
         .anyRequest().authenticated()
         .and()
         .httpBasic();
        http.headers().frameOptions().disable();
    }
	  
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
            .withUser(USERNAME)
            .password("{noop}password")
            .roles("USER");;
            
    }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
