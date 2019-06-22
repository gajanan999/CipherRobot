package com.cipher.utility;

import javax.crypto.spec.IvParameterSpec;

public interface IvParameterUtility {

	public IvParameterSpec get126BitIv();
	
	public IvParameterSpec get64BitIv();
}
