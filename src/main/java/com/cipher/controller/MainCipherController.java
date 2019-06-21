package com.cipher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cipher.entities.DataEntity;
import com.cipher.service.DataService;

@RestController
public class MainCipherController {

	@Autowired
	DataService dataService;
	
	@GetMapping("/getData")
	public List<DataEntity> getAllData() {
		return dataService.getAllDataEntities();
	}
	
}
