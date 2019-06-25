package com.cipher.serviceImpl;

import java.util.Base64;

import javax.crypto.Cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipher.utility.IvParameterUtility;
import com.cipher.utility.KeyUtility;

@Service
public class CipherIM {

	
	private static String secretKey = "b";
	private static String salt = "ssshhhhh";
	
	@Autowired
	KeyUtility keyUtility;
	
	@Autowired
	IvParameterUtility ivParameterUtility;
	
	@Autowired
	AESServiceImpl aESServiceImpl;
	 
	public String encrypt(String strToEncrypt, String secret)
	{
	    try
	    {  
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        cipher.init(Cipher.ENCRYPT_MODE, keyUtility.get128BitKey(), ivParameterUtility.get126BitIv());
	        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
	    }
	    catch (Exception e)
	    {
	        System.out.println("Error while encrypting: " + e.toString()+e);
	    }
	    return null;
	}
	
	public  String decrypt(String strToDecrypt, String secret) {
	    try
	    {
  
	        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, keyUtility.get128BitKey(), ivParameterUtility.get126BitIv());
	        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt.getBytes("UTF-8"))));
	    }
	    catch (Exception e) {
	        System.out.println("Error while decrypting: " + e.toString()+e);
	    }
	    return null;
	}
	
	
	public void doCipher() {
		
		String originalString = "Gajanan     hjhfjjhfjhgjhghjghjgjhghjgjhg";
	     
	    String encryptedString = encrypt(originalString, secretKey) ;
	    String decryptedString = decrypt(encryptedString, secretKey) ;
	    
	      
	    System.out.println(originalString);
	    System.out.println(encryptedString);
	    System.out.println(decryptedString);
	    System.out.println("************************** AES *******************************");
	    // encryptedString = aESServiceImpl.encrypt(originalString, secretKey) ;
	   //  decryptedString = aESServiceImpl.decrypt(encryptedString, secretKey) ;
	    
	      
	    System.out.println(originalString+ " "+ originalString.length());
	    System.out.println(encryptedString);
	    System.out.println(decryptedString);
	    
	    
	}
}
