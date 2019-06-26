package com.cipher.service;

import com.cipher.entities.UserEntity;

public interface UserService {

	public UserEntity createUser( UserEntity user);
	
	public UserEntity findUser( String username);

	public UserEntity updateUser(UserEntity user);

	public UserEntity login(UserEntity user);
}
