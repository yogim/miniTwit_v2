package com.ymhase.miniTwit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.dto.LoginDto;
import com.ymhase.miniTwit.model.Users;
import com.ymhase.miniTwit.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/forgotusername/{email:.+}")
	public Map<String, Object> forgotUsername(@PathVariable String email) {
		Map<String, Object> response = new HashMap<String, Object>();
		Users user = userService.getUserByEmail(email);
		response.put("username", user.getUsername());
		return response;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public Map<String, Object> login(@RequestBody LoginDto loginDto) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Users> userList = userService.findUserByUsername(loginDto);
		response.put("user-model", userList.get(0));
		return response;
	}
}
