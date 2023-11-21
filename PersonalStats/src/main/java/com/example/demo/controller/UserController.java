package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String helloWorld() {
		return "Hello World!";
	}

	@RequestMapping(value = "/findall", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

}
