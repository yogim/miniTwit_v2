package com.ymhase.miniTwit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymhase.miniTwit.dao.UserRepository;
import com.ymhase.miniTwit.dto.RegistrationDto;
import com.ymhase.miniTwit.model.Users;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Users registerUser(RegistrationDto registrationDto) {

		Users user = new Users();
		user.setFirstname(registrationDto.getFirstname());
		user.setLastname(registrationDto.getLastname());
		user.setUsername(registrationDto.getUsername());
		user.setEmail(registrationDto.getEmail());
		user.setPassword(registrationDto.getPassword());
		return userRepository.save(user);
	}

}
