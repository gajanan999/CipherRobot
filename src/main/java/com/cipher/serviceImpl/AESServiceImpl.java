package com.cipher.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cipher.config.Messages;
import com.cipher.service.CipherService;
import com.cipher.service.CryptographyService;
import com.cipher.utility.IvParameterUtility;
import com.cipher.utility.KeyUtility;

@Service
public class AESServiceImpl implements CryptographyService{
	
	private Logger logger = LoggerFactory.getLogger(AESServiceImpl.class);
	
	private  Cipher encryptCipher;
	private  Cipher decryptCipher;

	@Autowired
	KeyUtility keyUtility;
	
	@Autowired
	IvParameterUtility ivParameterUtility;
	
	@Autowired
	CipherService cipherService;
	
	@Autowired
    Messages messages;
	
	@Value("${AES_ALGORITHM}")
	private String algorithm;
	
	public String encrypt(String value, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
		
    	encryptCipher = Cipher.getInstance(algorithm);
    	encryptCipher.init(Cipher.ENCRYPT_MODE, keyUtility.get128BitKey(key));
		byte[] inputBytes = value.getBytes(StandardCharsets.ISO_8859_1);	
		return Base64.getEncoder().encodeToString((encryptCipher.doFinal(inputBytes)));
	    
	}

	
	public String decrypt(String encrypted, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
	
		decryptCipher = Cipher.getInstance(algorithm);
		decryptCipher.init(Cipher.DECRYPT_MODE, keyUtility.get128BitKey(key));
		byte[] oo=  Base64.getDecoder().decode(encrypted);
		//System.out.println(new String(decryptCipher.doFinal(oo)));
		return new String(decryptCipher.doFinal(oo));
	   
	}


	@Override
	public String getType() {
		 return "AES";
	}

}
