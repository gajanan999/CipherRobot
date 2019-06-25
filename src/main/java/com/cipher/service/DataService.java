package com.cipher.service;

import java.util.List;

import com.cipher.entities.DataEntity;
import com.cipher.vo.EncryptDecryptRequest;

public interface DataService {

	public List<DataEntity> getAllDataEntities();
	
	public DataEntity storeAndUpdateDataEntity(EncryptDecryptRequest request, String encryptedString, String username);
}
