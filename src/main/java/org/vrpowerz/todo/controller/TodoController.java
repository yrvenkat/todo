package org.vrpowerz.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vrpowerz.todo.repository.UserRepository;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	@RequestMapping("")
	public Response getAll(){
		return new Response(userRepository.findAll(), true);
	}

}
