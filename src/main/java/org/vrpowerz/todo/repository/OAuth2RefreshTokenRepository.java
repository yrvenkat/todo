package org.vrpowerz.todo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.vrpowerz.todo.model.OAuth2RefreshToken;

public interface OAuth2RefreshTokenRepository extends CassandraRepository<OAuth2RefreshToken, String> {

}
