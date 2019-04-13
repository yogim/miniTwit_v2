package com.ymhase.miniTwit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ymhase.miniTwit.dao.FollowerRepository;
import com.ymhase.miniTwit.dto.FollowerDto;
import com.ymhase.miniTwit.model.Users;
import com.ymhase.miniTwit.service.FollowerService;

@RestController
public class FollowerController {

	@Autowired
	FollowerService followerService;

	@RequestMapping(method = RequestMethod.POST, value = "/follow")
	public void followUser(@RequestBody FollowerDto followerDto) {

		followerService.followUser(followerDto);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/follower/{userid}")
	public Map<String, Object> getFollowerList(@PathVariable("userid") String userid) {

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("username", followerService.getFollowerListForUSerId(Integer.parseInt(userid)));
		return response;

	}

}
