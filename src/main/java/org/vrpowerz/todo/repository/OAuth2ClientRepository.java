package org.vrpowerz.todo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.vrpowerz.todo.model.OAuth2Client;

public interface OAuth2ClientRepository extends CassandraRepository<OAuth2Client, String>{

}
