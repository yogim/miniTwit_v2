package com.ymhase.miniTwit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymhase.miniTwit.dao.TwitRepository;
import com.ymhase.miniTwit.dto.TwitDto;
import com.ymhase.miniTwit.model.Twit;
import com.ymhase.miniTwit.model.Users;

@Service
public class TwitService {

	@Autowired
	TwitRepository twitRepository;

	@Autowired
	UserService userService;

	public Twit createtwit(int userid, TwitDto twitDto) {

		Twit twit = new Twit();
		Users user = new Users(userid, "", "", "", "", "", "");
		twit.setId(1);
		twit.setDeletestatus("A");
		twit.setUsers(user);
		twit.setDescription(twitDto.getTwit());
		return twitRepository.save(twit);
	}
	
	public List<Twit> getTwitByUserID(int userId){
		return twitRepository.findTwitByUserId(userId);
	}
	
}
