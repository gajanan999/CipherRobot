package com.cipher.utilityService;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipher.utility.GeneralUtility;
import com.cipher.utility.KeyUtility;

@Service
public class KeyUtilityService implements KeyUtility {
	
	@Autowired
	GeneralUtility generalUtility;

	@Override
	public SecretKeySpec get128BitKey() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		final byte[] pass = "47e7717f0f37ee72cb226278279aebef".getBytes("UTF-8");
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
	    byte[]  key = sha.digest(pass);
	    key = Arrays.copyOf(key, 16);
	    return new SecretKeySpec(key, "AES");
	}

	@Override
	public SecretKeySpec get128BitKey(String keyValue) throws UnsupportedEncodingException, NoSuchAlgorithmException {	
		if(null == keyValue || "" == keyValue) {
			keyValue="g";
		}
		final byte[] pass = keyValue.getBytes("UTF-8");
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
	    byte[]  key = sha.digest(pass);
	    key = Arrays.copyOf(key, 16);
	    return new SecretKeySpec(key, "AES");
	}
	
	@Override
	public SecretKey getDESKey(String desKey) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException { 
		byte[] keyBytes = DatatypeConverter.parseHexBinary(generalUtility.getDESKey(desKey));
		SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
		SecretKey key = factory.generateSecret(new DESKeySpec(keyBytes));
		return key;
	}

	
}
