package com.cipher.exception;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.cipher.vo.ApiError;
import com.cipher.vo.ApiResponse;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private ObjectMapper objectMapper = new ObjectMapper();
	 
    @Override
    public void onAuthenticationFailure(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException exception) 
      throws IOException, ServletException {
  
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        Map<String, Object> data = new HashMap<>();
        data.put(
          "timestamp", 
          Calendar.getInstance().getTime());
        data.put(
          "exception", 
          exception.getMessage());
        
      //  ApiError ApiError= new ApiError(HttpStatus.UNAUTHORIZED,exception.getMessage(),exception.getMessage());
        
        ApiResponse apiResponse=new ApiResponse();
		apiResponse.setStatus(HttpStatus.UNAUTHORIZED);
		apiResponse.setMessage(exception.getMessage());
		apiResponse.setCode("FAILURE");
        response.getOutputStream()
          .println(objectMapper.writeValueAsString(apiResponse));
        
    }
}
