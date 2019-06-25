package com.cipher.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus status;
    private String message;
    private List<String> errors;
    private String code;
   
    
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	 
    
    
    
}
