package com.driveanddeliver.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.driveanddeliver.dao.UserDAO;
import com.driveanddeliver.model.Address;
import com.driveanddeliver.model.User;
import com.driveanddeliver.repository.RoleRepository;
import com.driveanddeliver.repository.UserRepository;

public class UserServiceImpl implements UserService{

	private UserDAO userDAO;
	
	private UserRepository userRepository;

    private RoleRepository roleRepository;
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		this.userDAO.save(user);
	}

	@Override
	public User getUserDetails(String username) {
		return this.userDAO.getUserDetails(username);
		
	}	
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	@Autowired(required =true)
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public RoleRepository getRoleRepository() {
		return roleRepository;
	}

	@Autowired(required=true)
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public BCryptPasswordEncoder getbCryptPasswordEncoder() {
		return bCryptPasswordEncoder;
	}

	@Autowired(required=true)
	public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public User findByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Override
	public List<Address> getProfileAddress(String username) {
		return userDAO.getProfileAddress(username);
	}

	@Override
	public void addAddress(Address address) {
		this.userDAO.addAddress(address);
	}

}
