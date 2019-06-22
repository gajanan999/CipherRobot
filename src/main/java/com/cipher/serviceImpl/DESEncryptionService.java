package com.cipher.serviceImpl;

import javax.crypto.Cipher;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cipher.utility.IvParameterUtility;
import com.cipher.utility.KeyUtility;

@Service
public class DESEncryptionService {

	private static Cipher encryptCipher;
	private static Cipher decryptCipher;
	
	@Value("{DES_ALGORITHM}")
	private static String algorithm;
	
	@Autowired
	KeyUtility keyUtility;
	
	@Autowired
	IvParameterUtility ivParameterUtility;
	
	public String encrypt(String value,String desKey) {
		
		try {
 			encryptCipher = Cipher.getInstance(algorithm);
 			encryptCipher.init(Cipher.ENCRYPT_MODE, keyUtility.getDESKey(desKey), ivParameterUtility.get64BitIv());	 
	        byte[] encrypted = encryptCipher.doFinal(value.getBytes());
	        return Base64.encodeBase64String(encrypted);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return null;
	}

	
	public String decrypt(String encrypted,String desKey) {
		try {
			decryptCipher = Cipher.getInstance(algorithm);
			decryptCipher.init(Cipher.DECRYPT_MODE, keyUtility.getDESKey(desKey), ivParameterUtility.get64BitIv());
	        byte[] original = decryptCipher.doFinal(Base64.decodeBase64(encrypted));
	        return new String(original);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	 
	    return null;
	}
	
}
