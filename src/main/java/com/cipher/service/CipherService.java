package com.cipher.service;

/**
 * This is the base interface for Cryptography
 * @author gajagaik
 *
 */
public interface CipherService {

	public String encrypt(String value,String key,String algorithm) ;
	
	public String decrypt(String encrypted,String key,String algorithm);
}
