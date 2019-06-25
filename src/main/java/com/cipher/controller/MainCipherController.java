package com.cipher.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cipher.entities.DataEntity;
import com.cipher.exception.DatabaseException;
import com.cipher.service.CipherService;
import com.cipher.service.DataService;
import com.cipher.vo.DecryptionResponse;
import com.cipher.vo.EncryptDecryptRequest;

/**
 * This class is nothing but the controller for to control all the request coming from /api
 * @author gajagaik
 *
 */
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MainCipherController {

	@Autowired
	DataService dataService;
	
	@Autowired
	CipherService cipherService;
	
	/**
	 * To get all the datafrom the DataService
	 * @return List<DataEntity>
	 */
	@GetMapping("/getData")
	public List<DataEntity> getAllData() {
		return dataService.getAllDataEntities();
	}
	
	/**
	 * This function is used for to encrypt the data and store into the database using DataService
	 * @param EncryptDecryptRequest request
	 * @return String
	 * @throws Exception 
	 * @throws DatabaseException 
	 */
	@PostMapping(value="/getEncyption", consumes = "application/json")
	public DataEntity getEncyption(@RequestBody EncryptDecryptRequest entityVo, HttpServletRequest request) throws Exception {
		
		String encryptedString=cipherService.encrypt(entityVo.getText(), entityVo.getKey(), entityVo.getAlgorithm());
		DataEntity dataEntity=new DataEntity();
		if(null != encryptedString) {
			dataEntity = dataService.storeAndUpdateDataEntity(entityVo, encryptedString, request.getUserPrincipal().getName());
		}
		return dataEntity;

	}
	
	/**
	 * This function is used for to Decrypt the string which is passed in the request by using specified algorithm and key
	 * @param EncryptDecryptRequest entity
	 * @return
	 * @throws Exception 
	 */
	@PostMapping(value="/getDecryption", consumes = "application/json", produces="application/json")
	public DecryptionResponse getDecyption(@RequestBody EncryptDecryptRequest entityVo) throws Exception {
		return cipherService.decrypt(entityVo.getText(), entityVo.getKey(), entityVo.getAlgorithm());
		
	}
}
