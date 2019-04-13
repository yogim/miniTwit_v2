package com.ymhase.miniTwit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymhase.miniTwit.dao.FollowerRepository;
import com.ymhase.miniTwit.dto.FollowerDto;
import com.ymhase.miniTwit.model.Relationship;
import com.ymhase.miniTwit.model.Users;


@Service
public class FollowerService {
	
	@Autowired
	FollowerRepository followerRepository;

	public FollowerRepository getFollowerRepository() {
		return followerRepository;
	}

	public void setFollowerRepository(FollowerRepository followerRepository) {
		this.followerRepository = followerRepository;
	}
	
	public void followUser(FollowerDto followerDto) {
		
		Relationship relationshipmap = new Relationship();
		Users who_user = new Users(followerDto.getWho_id());
		Users whom_user = new Users(followerDto.getWhom_id());
		relationshipmap.setFollowed(who_user);
		relationshipmap.setFollower(whom_user);
		followerRepository.save(relationshipmap);
		
	}
	
	
	public List<Users> getFollowerListForUSerId(Integer userId){
		//Users user = new Users(userId, "", "", "", "", "", "");
		return followerRepository.getFollowerListForUSerId(userId);
	}
	
	
	 

}
