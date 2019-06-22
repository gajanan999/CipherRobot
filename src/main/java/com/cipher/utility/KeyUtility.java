package com.cipher.utility;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public interface KeyUtility {

	public SecretKeySpec get128BitKey() throws UnsupportedEncodingException, NoSuchAlgorithmException;
	
	public SecretKeySpec get128BitKey(String value) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	
	public SecretKey getDESKey(String desKey) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException;
}
