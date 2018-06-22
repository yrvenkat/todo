package org.vrpowerz.todo.app.OAuth2config;


import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.vrpowerz.todo.model.Role;
import org.vrpowerz.todo.model.User;
import org.vrpowerz.todo.repository.RoleRepository;
import org.vrpowerz.todo.repository.UserRepository;

/**
 * Created on 5/22/16.
 */
@Service
public class CassandraUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

	@Autowired
    private RoleRepository roleRepository;

    private GrantedAuthorityCreater grantedAuthorityCreater = new GrantedAuthorityCreater();


    @Autowired
    public void setGrantedAuthorityCreater(GrantedAuthorityCreater grantedAuthorityCreater) {
        this.grantedAuthorityCreater = grantedAuthorityCreater;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username);
    	Optional<Role> roles =  roleRepository.findById(user.getUserRole());
    	HashSet<String> _roles = new HashSet<>();
    	_roles.add(roles.get().getRoleKey());
        return user != null ? new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(),
                true, true, true, grantedAuthorityCreater.fromCollection(_roles)) : null;
    }

}
