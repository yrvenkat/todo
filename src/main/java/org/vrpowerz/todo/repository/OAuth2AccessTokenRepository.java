package org.vrpowerz.todo.repository;


import org.springframework.data.cassandra.repository.CassandraRepository;
import org.vrpowerz.todo.model.OAuth2AccessToken;

public interface OAuth2AccessTokenRepository extends CassandraRepository<OAuth2AccessToken, String> {


}
