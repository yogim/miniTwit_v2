package com.ymhase.miniTwit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ymhase.miniTwit.model.Users;

public interface UserRepository extends CrudRepository<Users, String> {

	Users findByEmail(String email);

	//@Query("SELECT first_name, last_name, email FROM users WHERE user_name = :username AND password = :password")
	@Query(value = "from users where username = :username and password = :password")
	List<Users> findUserByUsername(@Param ("username")String username, @Param("password")String password);

}
