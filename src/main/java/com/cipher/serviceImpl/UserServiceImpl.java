package com.cipher.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cipher.dao.UserRepository;
import com.cipher.entities.UserEntity;
import com.cipher.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserEntity createUser(UserEntity user) { 
		return userRepository.save(user);
	}

	@Override
	public UserEntity findUser(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		UserEntity found=findUser(user.getUsername());
		if(null != found) {
			found.setUserid(found.getUserid());
			found.setPassword(user.getPassword());
			found.setKey(user.getKey());
			return userRepository.save(found);
		}
		return userRepository.save(user);
	}

	@Override
	public UserEntity login(UserEntity user) {
		UserEntity found=findUser(user.getUsername());
		if(user.getPassword().equals(found.getPassword())) {
			return found;
		}
		return null;
	}

}
