package org.vrpowerz.todo.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vrpowerz.todo.app.OAuth2config.PasswordEncoders;
import org.vrpowerz.todo.enums.Gender;
import org.vrpowerz.todo.model.OAuth2Client;
import org.vrpowerz.todo.model.User;
import org.vrpowerz.todo.repository.OAuth2ClientRepository;
import org.vrpowerz.todo.repository.UserRepository;

@Controller
@RequestMapping("/create")
public class SampleController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoders passwordEncoders;
	@Autowired
	private OAuth2ClientRepository clientRepository;

	@GetMapping("/all")
	public String home(){
		System.out.println("occurs");
		//roleRepository.save(new Role(null, Calendar.getInstance().getTime(), new HashSet<>(Arrays.asList(new String[]{"ROLE_ADMIN", "Admin"})), "Admin", "ROLE_ADMIN", "General admin role"));
		userRepository.save(new User(null, Calendar.getInstance().getTime(), new HashSet<>(Arrays.asList(new String[]{"venkat", "password", "venkat", "yr", String.valueOf(Gender.Male), "venkat@nbtechnology.in", "9500032425"})), "venkat", passwordEncoders.getUserPasswordEncoder().encode("password"), "venkat", "yr", Gender.Male, "venkat@nbtechnology.in", "9500032425", true, UUID.fromString("b1cb9700-73d8-11e8-b7bc-f5b5f811ed09"), UUID.fromString("b1cb9700-73d8-11e8-b7bc-f5b5f811ed09")));
		
		
		OAuth2Client client = new OAuth2Client();
		client.setClient_id("todo_gl_api");
		client.setAccess_token_validity(60);
		client.setAdditional_info("");
		client.setAuthorities(new HashSet<String>(Arrays.asList(new String[] {"admin", "user"})));
		client.setGrant_types(new HashSet<String>(Arrays.asList(new String[] {"authorization_code", "client_credentials", "password", "refresh_token"})));
		client.setRedirect_url("/");
		client.setRefresh_token_validity(90);
		client.setScope(new HashSet<String>(Arrays.asList(new String[] {"openid"})));
		client.setClient_secret(passwordEncoders.getOAuth2ClientPasswordEncoder().encode("redhat"));
		clientRepository.save(client);
		
		return new String();
	}
}
