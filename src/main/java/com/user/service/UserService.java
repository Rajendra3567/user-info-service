package com.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.user.DTO.UserDTO;
import com.user.entity.User;
import com.user.mapper.UserMapper;
import com.user.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;

	public UserDTO addUser(UserDTO userDTO) {
		User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOTOUser(userDTO));
		UserDTO userDetails = UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
		return userDetails;
	}

	public ResponseEntity<UserDTO> findUserById(Integer userId) {
			Optional<User> user = userRepo.findById(userId);
			if(user.isPresent()) 
				return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.OK);
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);	
	}
}
