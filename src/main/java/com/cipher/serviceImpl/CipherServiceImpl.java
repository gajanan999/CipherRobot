package com.cipher.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipher.service.CipherService;

@Service
public class CipherServiceImpl implements CipherService{
	

	@Autowired
	AESServiceImpl aesServiceImpl;
	
	DESEncryptionService desEncryptionService;
	
	@Override
	public String encrypt(String value,String key,String algorithm){
		if(algorithm == "AES") {
			return aesServiceImpl.encrypt(value, key);
		}else {
			return desEncryptionService.encrypt(value, key);
		}
		
	}

	@Override
	public String decrypt(String encrypted,String key,String algorithm){
		if(algorithm == "AES") {
			return aesServiceImpl.encrypt(encrypted, key);
		}else {
			return desEncryptionService.encrypt(encrypted, key);
		}
	}
	

}
