package com.cipher.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public interface CryptographyService {

	public String getType();
	
	public String encrypt(String value,String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException  ;
	
	public String decrypt(String encrypted,String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException;
}
