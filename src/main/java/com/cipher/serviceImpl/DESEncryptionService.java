package com.cipher.serviceImpl;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cipher.config.Messages;
import com.cipher.service.CryptographyService;
import com.cipher.utility.IvParameterUtility;
import com.cipher.utility.KeyUtility;

@Service
public class DESEncryptionService implements CryptographyService{

	private static Cipher encryptCipher;
	private static Cipher decryptCipher;
	
	@Value("${DES_ALGORITHM}")
	private String algorithm;
	
	@Autowired
	KeyUtility keyUtility;
	
	@Autowired
	IvParameterUtility ivParameterUtility;
	
	@Autowired
    Messages messages;
	
	public String encrypt(String value,String desKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException  {
		
 			encryptCipher = Cipher.getInstance(algorithm);
 			encryptCipher.init(Cipher.ENCRYPT_MODE, keyUtility.getDESKey(desKey), ivParameterUtility.get64BitIv());	 
	        byte[] encrypted = encryptCipher.doFinal(value.getBytes());
	        return Base64.encodeBase64String(encrypted);
	}

	
	public String decrypt(String encrypted,String desKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
	
		decryptCipher = Cipher.getInstance(algorithm);
		decryptCipher.init(Cipher.DECRYPT_MODE, keyUtility.getDESKey(desKey), ivParameterUtility.get64BitIv());
        byte[] original = decryptCipher.doFinal(Base64.decodeBase64(encrypted));
        return new String(original);
	   
	}


	@Override
	public String getType() {
		
		return "DES";
	}
	
}
