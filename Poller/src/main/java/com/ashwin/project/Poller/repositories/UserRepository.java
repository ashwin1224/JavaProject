package com.ashwin.project.Poller.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwin.project.Poller.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
		User findByUsername(String username);
		
	}
