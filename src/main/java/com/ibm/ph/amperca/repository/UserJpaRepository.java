package com.ibm.ph.amperca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.ph.amperca.todoapp.model.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {
	
}
