package com.cipher.service;

public interface CipherService {

	public String encrypt(String value,String key,String algorithm) ;
	
	public String decrypt(String encrypted,String key,String algorithm);
}
