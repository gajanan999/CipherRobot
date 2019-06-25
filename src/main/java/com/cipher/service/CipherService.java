package com.cipher.service;

import com.cipher.vo.DecryptionResponse;

/**
 * This is the base interface for Cryptography
 * @author gajagaik
 *
 */
public interface CipherService {

	public String encrypt(String value,String key,String algorithm) throws Exception ;
	
	public DecryptionResponse decrypt(String encrypted,String key,String algorithm) throws Exception;
}
