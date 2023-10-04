package com.eyup.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eyup.crud.converter.UserConverter;
import com.eyup.crud.dto.UserCreateRequest;
import com.eyup.crud.dto.UserDto;
import com.eyup.crud.dto.UserUpdateDto;
import com.eyup.crud.exception.UserNotFoundException;
import com.eyup.crud.model.User;
import com.eyup.crud.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserConverter userConverter;
	
	public UserService(UserRepository userRepository, UserConverter userConverter) {
		this.userRepository = userRepository;
		this.userConverter = userConverter;
	}
	
	public UserDto createUser(UserCreateRequest userCreateRequest) {
		final User user = userRepository.save(userConverter.userRequestConverter(userCreateRequest));
		return userConverter.userDtoConverter(user);
	}
	
	public List<UserDto> getAllUser(){
		return userRepository.findAll().stream().map(userConverter::userDtoConverter).toList();
	}
	
	public UserDto getUserById(Long id) {
		final User user = userRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException("user not found id : " + id));
	
		return userConverter.userDtoConverter(user);
	}
	
	public void deleteUserById(Long id) {
		final User user = userRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException("user not found id : " + id));
		userRepository.delete(user);
	}
	
	public UserDto updateUser(UserUpdateDto userUpdateDto, Long id) {
		final User user = userRepository.findById(id)
				.orElseThrow(()->new UserNotFoundException("user not found id : " + id));
		user.setCity(userUpdateDto.getName());
		user.setSurName(userUpdateDto.getSurName());
		user.setCity(userUpdateDto.getCity());
		user.setPhoneNumber(userUpdateDto.getPhoneNumber());
		
		final User saveUser = userRepository.save(user);
		return userConverter.userDtoConverter(saveUser);
	}
	
	
}























