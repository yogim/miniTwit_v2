package com.ymhase.miniTwit.dao;

import org.springframework.data.repository.CrudRepository;

import com.ymhase.miniTwit.model.Users;

public interface UserRepository extends CrudRepository<Users, String> {


}
