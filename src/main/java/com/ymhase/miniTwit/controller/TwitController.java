package com.ymhase.miniTwit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ymhase.miniTwit.dto.TwitDto;
import com.ymhase.miniTwit.service.TwitService;

@RestController
public class TwitController {

	@Autowired
	TwitService twitService;

	@RequestMapping(method = RequestMethod.POST, value = "/twit")
	public void twit(@RequestBody TwitDto twitDto, HttpServletRequest req, HttpServletResponse response) {
		int userid = 1;
		twitService.createtwit(userid, twitDto);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/twit/{userID}")
	public void getTwitsByuserId(@PathVariable("userID") TwitDto twitDto, HttpServletRequest req, HttpServletResponse response) {
		int userid = 1;
		twitService.createtwit(userid, twitDto);
	}

}
