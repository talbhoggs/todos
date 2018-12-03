package com.ibm.ph.amperca.todoapp.service;

import java.util.ArrayList;

import com.ibm.ph.amperca.todoapp.model.User;

public interface UserService {
	
	void deleteById(Integer id);

	void delete(User user);
	
	ArrayList<User> findAll();
	
	User findById(Integer id);
}
