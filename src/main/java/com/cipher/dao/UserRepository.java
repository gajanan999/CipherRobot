package com.cipher.dao;

import org.springframework.data.repository.CrudRepository;

import com.cipher.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

	public UserEntity findByUsername(String username);
}
