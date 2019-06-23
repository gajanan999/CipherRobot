package com.cipher.service;

public interface CryptographyService {

	public String getType();
	
	public String encrypt(String value,String key) ;
	
	public String decrypt(String encrypted,String key);
}
