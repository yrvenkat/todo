package org.vrpowerz.todo.app.OAuth2config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoders {
	
	public PasswordEncoder getOAuth2ClientPasswordEncoder(){
		return new BCryptPasswordEncoder(4);
	}
	
	public PasswordEncoder getUserPasswordEncoder(){
		return new BCryptPasswordEncoder(12);
	}

}
