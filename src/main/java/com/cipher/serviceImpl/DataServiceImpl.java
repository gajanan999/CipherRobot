package com.cipher.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipher.dao.DataRepository;
import com.cipher.entities.DataEntity;
import com.cipher.service.DataService;

@Service
public class DataServiceImpl implements DataService{

	@Autowired
	DataRepository dataRepository;
	
	@Override
	public List<DataEntity> getAllDataEntities() {
		return (List<DataEntity>) dataRepository.findAll();
	}
}
