package com.cipher.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipher.dao.DataRepository;
import com.cipher.entities.DataEntity;
import com.cipher.exception.DatabaseException;
import com.cipher.service.DataService;
import com.cipher.vo.EncryptDecryptRequest;

@Service
public class DataServiceImpl implements DataService{
	
	private Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);

	@Autowired
	DataRepository dataRepository;
	
	
	@Override
	public List<DataEntity> getAllDataEntities() {
		try {
			return (List<DataEntity>) dataRepository.findAll();
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return new ArrayList<DataEntity>();
	}
	
	/**
	 * This function is used for store the text data int the dataentity table
	 * @throws DatabaseException 
	 */
	public boolean storeAndUpdateDataEntity(EncryptDecryptRequest request,String username) {
		try {
			DataEntity dataEntity=new DataEntity();
			dataEntity.setText(request.getText());
			dataEntity.setKey(request.getKey());
			dataEntity.setAlgorithm(request.getAlgorithm());
			if(null != username && ""!=username) {
				dataEntity.setUserName(username);
				dataRepository.save(dataEntity);
				return true;
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
		
	}
}
