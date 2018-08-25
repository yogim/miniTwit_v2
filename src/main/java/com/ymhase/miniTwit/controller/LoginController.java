package com.ymhase.miniTwit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.dto.LoginDto;
import com.ymhase.miniTwit.exception.CustomException;
import com.ymhase.miniTwit.exception.ErrorCode;
import com.ymhase.miniTwit.model.UserModel;
import com.ymhase.miniTwit.service.SessionService;
import com.ymhase.miniTwit.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	SessionService sessionService;
	
	private static final Logger logger = Logger.getLogger(LoginController.class);


	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public Map<String, Object> login(@RequestBody @Valid LoginDto loginDto) throws CustomException {

		Map<String, Object> response = new HashMap<String, Object>();
		if ((userService.isUserValid(loginDto.getUsername(), loginDto.getPassword()))) {
			UserModel model = userService.getUserbyUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
			response.put("usermodel", model);
			response.put("session-key", sessionService.createSession(model.getUserid()));
			logger.info("logging user");
		} else {
			throw new CustomException(ErrorCode.NOT_FOUND);
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/forgotusername/{email:.+}")
	public Map<String, Object> forgotUsername(@PathVariable String email) throws CustomException {

		Map<String, Object> response = new HashMap<String, Object>();
		String username = userService.forgotUsername(email);

		if (username.equals(null) || " ".equals(username))
			throw new CustomException(ErrorCode.NOT_FOUND);

		response.put("username", username);
		return response;

	}

}
