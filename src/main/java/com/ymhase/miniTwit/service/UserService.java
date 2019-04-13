package com.ymhase.miniTwit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ymhase.miniTwit.dao.UserDao;
import com.ymhase.miniTwit.dao.UserRepository;
import com.ymhase.miniTwit.dto.LoginDto;
import com.ymhase.miniTwit.dto.RegistrationDto;
import com.ymhase.miniTwit.model.Users;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserDao userDao;

	public Users registerUser(RegistrationDto registrationDto) {

		Users user = new Users();
		user.setFirstname(registrationDto.getFirstname());
		user.setLastname(registrationDto.getLastname());
		user.setUsername(registrationDto.getUsername());
		user.setEmail(registrationDto.getEmail());
		user.setPassword(registrationDto.getPassword());
		return userRepository.save(user);
	}

	public void insertUser(RegistrationDto registrationDto) {

		Users user = new Users();
		user.setFirstname(registrationDto.getFirstname());
		user.setLastname(registrationDto.getLastname());
		user.setUsername(registrationDto.getUsername());
		user.setEmail(registrationDto.getEmail());
		user.setPassword(registrationDto.getPassword());
		userDao.insertuser(user);

	}

	public void deleteUser(String id) {
		userRepository.delete(id);
	}

	public void getUserById(int id) {

		/* userRepository.findOne(id); */
	}

	public Users getUserByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	public List<Users> findUserByUsername(LoginDto loginDto) {

		return userRepository.findUserByUsername(loginDto.getUsername(), loginDto.getPassword());
	}

}
