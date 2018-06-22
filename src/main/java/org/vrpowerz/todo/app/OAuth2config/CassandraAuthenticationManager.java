package org.vrpowerz.todo.app.OAuth2config;


import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.vrpowerz.todo.model.Role;
import org.vrpowerz.todo.model.User;
import org.vrpowerz.todo.repository.RoleRepository;
import org.vrpowerz.todo.repository.UserRepository;


@Primary
@Component
public class CassandraAuthenticationManager implements AuthenticationManager {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoders passwordEncoders;

    private GrantedAuthorityCreater grantedAuthorityCreater = new GrantedAuthorityCreater();


    @Autowired
    public void setGrantedAuthorityCreater(GrantedAuthorityCreater grantedAuthorityCreater) {
        this.grantedAuthorityCreater = grantedAuthorityCreater;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String username = authentication.getName();
        final User user = userRepository.findByUsername(username);
        
        if (user != null && passwordEncoders.getUserPasswordEncoder().matches(authentication.getCredentials().toString(), user.getPassword())) {
        	Optional<Role> roles =  roleRepository.findById(user.getUserRole());
        	HashSet<String> _roles = new HashSet<>();
        	_roles.add(roles.get().getRoleKey());
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), grantedAuthorityCreater.fromCollection(_roles));
        }else{
        	throw new BadCredentialsException("Bad Credentials");
        }
    }
    

}
