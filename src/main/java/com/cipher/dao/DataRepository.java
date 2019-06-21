package com.cipher.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cipher.entities.DataEntity;

public interface DataRepository extends CrudRepository<DataEntity, Long>{

	
}
