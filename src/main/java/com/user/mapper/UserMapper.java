package com.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.user.DTO.UserDTO;
import com.user.entity.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	User mapUserDTOTOUser(UserDTO userDTO);
	UserDTO mapUserToUserDTO(User user);

}
