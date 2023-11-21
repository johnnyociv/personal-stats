package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		
		try {
			userList = userRepository.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}
}
