package com.ymhase.miniTwit.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ymhase.miniTwit.model.Users;

@Repository
public class UserDao {

	@Autowired
	private EntityManager entityManager;

	public void insertuser(Users user) {
		Session session = entityManager.unwrap(Session.class);
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

}
