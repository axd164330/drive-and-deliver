package com.driveanddeliver.repository;

import com.driveanddeliver.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
}
