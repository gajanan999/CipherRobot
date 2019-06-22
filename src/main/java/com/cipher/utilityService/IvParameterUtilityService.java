package com.cipher.utilityService;

import javax.crypto.spec.IvParameterSpec;

import org.springframework.stereotype.Service;

import com.cipher.utility.IvParameterUtility;

@Service
public class IvParameterUtilityService implements IvParameterUtility {

	 byte[] iv126bit = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	 byte[] iv64bit = { 0, 0, 0, 0, 0, 0, 0, 0,};
	@Override
	public IvParameterSpec get126BitIv() {
		IvParameterSpec ivspec = new IvParameterSpec(iv126bit);
		return ivspec;
	}
	@Override
	public IvParameterSpec get64BitIv() {
		IvParameterSpec ivspec = new IvParameterSpec(iv64bit);
		return ivspec;
	}

	
}
