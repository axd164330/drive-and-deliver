package com.driveanddeliver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveanddeliver.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	
}

