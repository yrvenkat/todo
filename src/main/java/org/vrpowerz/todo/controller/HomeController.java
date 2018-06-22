package org.vrpowerz.todo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vrpowerz.todo.model.User;
import org.vrpowerz.todo.repository.UserRepository;

@RestController
@RequestMapping("/")
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String home(){
		return new String("Works as expected!");
	}
	
	@GetMapping("users")
	public List<User> get(){
		return userRepository.findAll();
	}
	
	@GetMapping("users/{username}")
	public User get(@PathVariable("username") String Username){
		return userRepository.findByUsername(Username);
	}
	
	@GetMapping("users/id/{userid}")
	public User get(@PathVariable("userid") UUID id){
		return userRepository.findById(id).orElse(null);
	}
	
	
	
}
