package com.eyup.crud.converter;


import org.springframework.stereotype.Component;

import com.eyup.crud.dto.UserCreateRequest;
import com.eyup.crud.dto.UserDto;
import com.eyup.crud.model.User;

@Component
public class UserConverter {		//model yani db dışarı açamadık buradan kontrol edeceğiz

	public UserDto userDtoConverter(User user) {
		return UserDto.builder()
				.name(user.getName())
				.surName(user.getSurName())
				.city(user.getCity())
				.phoneNumber(user.getPhoneNumber())
				.build();
	}
	
	public User userRequestConverter(UserCreateRequest userCreateRequest) {
		return User.builder()
				.name(userCreateRequest.getName())
				.surName(userCreateRequest.getSurName())
				.city(userCreateRequest.getCity())
				.phoneNumber(userCreateRequest.getPhoneNumber())
				.build();
	}
}
