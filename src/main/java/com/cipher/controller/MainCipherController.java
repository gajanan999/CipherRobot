package com.cipher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cipher.entities.DataEntity;
import com.cipher.service.CipherService;
import com.cipher.service.DataService;
import com.cipher.serviceImpl.AESServiceImpl;
import com.cipher.serviceImpl.CipherIM;
import com.cipher.serviceImpl.Cyptography;
import com.cipher.serviceImpl.DESEncryptionService;
import com.cipher.vo.EncryptDecryptRequest;

@RestController
public class MainCipherController {

	@Autowired
	DataService dataService;
	
	@Autowired
	Cyptography cyptography;
	@Autowired
	CipherIM cipher;
	
	@Autowired
	AESServiceImpl aESServiceImpl;
	
	@Autowired
	DESEncryptionService dESEncryptionService;
	
	@Autowired
	CipherService cipherService;
	
	@GetMapping("/getData")
	public List<DataEntity> getAllData() {
		return dataService.getAllDataEntities();
	}
	
	@PostMapping(value="/getEncyption", consumes = "application/json")
	public String getEncyption(@RequestBody EncryptDecryptRequest entity) {
		return cipherService.encrypt(entity.getText(), entity.getKey(), entity.getAlgorithm());
	}
	
	@PostMapping(value="/getDecryption", consumes = "application/json")
	public String getDecyption(@RequestBody EncryptDecryptRequest entity) {
		return cipherService.decrypt(entity.getText(), entity.getKey(), entity.getAlgorithm());
	}
}
