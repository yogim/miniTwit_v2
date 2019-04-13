package com.ymhase.miniTwit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ymhase.miniTwit.model.Twit;

public interface TwitRepository extends CrudRepository<Twit, String> {

	@Query(value = "from Twit where user_id = :userId")
	List<Twit> findTwitByUserId(@Param("userId") int userId);

}
