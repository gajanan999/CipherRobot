package com.cipher.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipher.service.CipherService;

@Service
public class CipherServiceImpl implements CipherService{
	

	@Autowired
	AESServiceImpl aesServiceImpl;
	
	@Autowired
	DESEncryptionService desEncryptionService;
	
	@Autowired
	CryptographyFactory cryptographyFactory;
	
	@Override
	public String encrypt(String value,String key,String algorithm){
		return cryptographyFactory.getService("AESService").encrypt(value, key);
		
//		if(algorithm.equals("AES")) {
//			return aesServiceImpl.encrypt(value, key);
//		}else {
//			return desEncryptionService.encrypt(value, key);
//		}
		
	}

	@Override
	public String decrypt(String encrypted,String key,String algorithm){
		if(algorithm.equals("AES")) {
			return aesServiceImpl.decrypt(encrypted, key);
		}else {
			return desEncryptionService.decrypt(encrypted, key);
		}
	}
	

}
