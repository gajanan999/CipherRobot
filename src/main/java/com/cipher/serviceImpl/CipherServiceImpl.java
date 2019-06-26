package com.cipher.serviceImpl;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipher.service.CipherService;
import com.cipher.vo.DecryptionResponse;

@Service
public class CipherServiceImpl implements CipherService{
	

	@Autowired
	AESServiceImpl aesServiceImpl;
	
	@Autowired
	DESEncryptionService desEncryptionService;
	
	@Autowired
	CryptographyFactory cryptographyFactory;
	
	@Override
	public String encrypt(String value,String key,String algorithm) throws Exception {
		try {
			return cryptographyFactory.getService(algorithm).encrypt(value, key);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | InvalidKeySpecException | IllegalBlockSizeException
				| BadPaddingException e) {
			throw new Exception(e.getMessage());
		}	
	}

	@Override
	public DecryptionResponse decrypt(String encrypted,String key,String algorithm) throws Exception {
		DecryptionResponse response= new DecryptionResponse();
		try {
			String decryptedText = cryptographyFactory.getService(algorithm).decrypt(encrypted, key);
			response.setDecryptedText(decryptedText);
			response.setEncryptedText(encrypted);
			response.setStatus("SUCCESS");
			response.setMessage("SUCCESS");
			return response;
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | InvalidKeySpecException e) {
			throw new Exception(e.getMessage());
		}
		
//		if(algorithm.equals("AES")) {
//			return aesServiceImpl.decrypt(encrypted, key);
//		}else {
//			return desEncryptionService.decrypt(encrypted, key);
//		}
	}
	

}
