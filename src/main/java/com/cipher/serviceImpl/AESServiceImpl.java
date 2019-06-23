package com.cipher.serviceImpl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cipher.service.CipherService;
import com.cipher.service.CryptographyService;
import com.cipher.utility.IvParameterUtility;
import com.cipher.utility.KeyUtility;

@Service
public class AESServiceImpl implements CryptographyService{
	
	private static Cipher encryptCipher;
	private static Cipher decryptCipher;

	@Autowired
	KeyUtility keyUtility;
	
	@Autowired
	IvParameterUtility ivParameterUtility;
	
	@Autowired
	CipherService cipherService;
	
	@Value("${AES_ALGORITHM}")
	private String algorithm;
	
	public String encrypt(String value, String key) {
		
	    try {
	    	encryptCipher = Cipher.getInstance(algorithm);
	    	encryptCipher.init(Cipher.ENCRYPT_MODE, keyUtility.get128BitKey(key));
			byte[] inputBytes = value.getBytes(StandardCharsets.ISO_8859_1);	
			return Base64.getEncoder().encodeToString((encryptCipher.doFinal(inputBytes)));
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}

	
	public String decrypt(String encrypted, String key) {
		try { 
			decryptCipher = Cipher.getInstance(algorithm);
			decryptCipher.init(Cipher.DECRYPT_MODE, keyUtility.get128BitKey(key));
			byte[] oo=  Base64.getDecoder().decode(encrypted.getBytes("UTF-8"));
			return new String(decryptCipher.doFinal(oo));
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	 
	    return null;
	}


	@Override
	public String getType() {
		 return "AESService";
	}

}
