package org.vrpowerz.todo.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.vrpowerz.todo.model.User;

@Repository
public interface UserRepository extends CassandraRepository<User, UUID> {
	
	User findByUsername(String username);
	
}
