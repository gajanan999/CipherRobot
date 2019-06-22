package com.cipher.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Cyptography {
	
	@Autowired
	AESServiceImpl aESServiceImpl;
	
	@Autowired
	DESEncryptionService dESEncryptionService;
	private String key="aesEncryptionKey";
	
	public String doEncryption(String value) {
		System.out.println("AES Encyption: "+aESServiceImpl.encrypt(value, key));
		//System.out.println("DES: "+dESEncryptionService.encrypt(value));
		return aESServiceImpl.encrypt(value, key);
	}
	
	public String doDecryption(String encryptedValue) {
		System.out.println("AES Decryption: "+aESServiceImpl.decrypt(encryptedValue, key));
		//System.out.println("DES: "+dESEncryptionService.decrypt(encryptedValue));
		return aESServiceImpl.decrypt(encryptedValue, key);
	}

}
