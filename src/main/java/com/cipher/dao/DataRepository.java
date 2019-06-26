package com.cipher.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cipher.entities.DataEntity;

public interface DataRepository extends CrudRepository<DataEntity, Long>{

	//@Query("SELECT u FROM dataentity u WHERE u.text = ?1")
	public DataEntity findByText(String text);
}
