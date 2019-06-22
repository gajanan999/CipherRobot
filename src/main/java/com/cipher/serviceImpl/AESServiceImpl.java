package com.cipher.serviceImpl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipher.service.CipherService;
import com.cipher.utility.IvParameterUtility;
import com.cipher.utility.KeyUtility;

@Service
public class AESServiceImpl{

	@Autowired
	KeyUtility keyUtility;
	
	@Autowired
	IvParameterUtility ivParameterUtility;
	
	@Autowired
	CipherService cipherService;
	
	private static String algorithm="AES/ECB/PKCS5Padding";
	
	public String encrypt(String value, String key) {
		
	    try {
	    	Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, keyUtility.get128BitKey(key));
			byte[] inputBytes = value.getBytes(StandardCharsets.ISO_8859_1);	
			return Base64.getEncoder().encodeToString((cipher.doFinal(inputBytes)));
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}

	
	public String decrypt(String encrypted, String key) {
		try { 
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, keyUtility.get128BitKey(key));
			byte[] oo=  Base64.getDecoder().decode(encrypted.getBytes("UTF-8"));
			return new String(cipher.doFinal(oo));
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	 
	    return null;
	}

}
