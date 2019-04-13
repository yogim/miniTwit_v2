package com.ymhase.miniTwit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ymhase.miniTwit.model.Relationship;
import com.ymhase.miniTwit.model.Users;

public interface FollowerRepository extends CrudRepository<Relationship	, String>{
/*
	@Query(
			"SELECT users.user_id , "+
			"users.first_name  , "+
			"users.last_name  "+
			"FROM"+ 
			"users "+
			"LEFT JOIN followermap  ON users.user_id = followermap.followed"+ 
			"WHERE followermap.followed = :userid ")*/
	
	@Query("select a from users as a join a.Relationship as RM where RM.followed = :userid")
	List<Users> getFollowerListForUSerId(@Param("userid") int userId);
	

}
