package com.cipher.utility;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

@Component
public class GeneralUtility {

	public String get16ByteDESkeyString(String key) {
		if(null == key || "" == key) {
			key="g";
		}
		if(key.length() < 16) {
			while(key.length() != 16) {
				key=key+key;
				if(key.length()>16)
					key=key.substring(0,16);
			}
			return key;
		}else if(key.length() > 16) {
			return key.substring(0,16);
		}else {
			return key;
		}
			
	}
	
	public String getDESKey(String text)
	{
		text=get16ByteDESkeyString(text);
	    byte[] myBytes=null;
		try {
			myBytes = text.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println();
	    return DatatypeConverter.printHexBinary(myBytes);
	}
}
