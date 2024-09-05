package com.hibernate.main.service;

import java.util.List;

import com.hibernate.main.enums.RoleType;
import com.hibernate.main.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class UserService {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction; 
	
	public UserService(EntityManager entityManager, EntityTransaction entityTransaction) {
		this.entityManager = entityManager;
		this.entityTransaction = entityTransaction;
	}

	 
	public boolean login(User user) {
		//step 1: begin the transaction 
		entityTransaction.begin();
		//execute the query 
		String sql="select u from User u where u.username=?1 and u.password=?2 and u.role=?3";
		Query query = entityManager.createQuery(sql, User.class); 
		query.setParameter(1, user.getUsername());
		query.setParameter(2, user.getPassword());
		query.setParameter(3, RoleType.CUSTOMER); 
		
		@SuppressWarnings("unchecked")
		List<User> list = query.getResultList();
		if(list != null && list.isEmpty()) {
			entityTransaction.commit();
			return false; 
		}
		//commit the transaction
		entityTransaction.commit();
		return true; 
		
	}

}
