package com.eyup.crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eyup.crud.dto.UserCreateRequest;
import com.eyup.crud.dto.UserDto;
import com.eyup.crud.dto.UserUpdateDto;
import com.eyup.crud.service.UserService;

@RestController
@RequestMapping("v1/user")
public class UserController {

	private final UserService userSevice;

	public UserController(UserService userSevice) {
		this.userSevice = userSevice;
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserCreateRequest userCreateRequest){
		
		return new ResponseEntity<>(userSevice.createUser(userCreateRequest), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserDto>> getAllUser(){
		return new ResponseEntity<>(userSevice.getAllUser(), HttpStatus.OK);
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
		return new ResponseEntity<>(userSevice.getUserById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
		userSevice.deleteUserById(id);
		return ResponseEntity.ok().build();
	}
	
	
	public ResponseEntity<UserDto> updateUser(@RequestBody UserUpdateDto userUpdateDto, @PathVariable Long id){
		return new ResponseEntity<>(userSevice.updateUser(userUpdateDto, id), HttpStatus.OK);
	}
}


















