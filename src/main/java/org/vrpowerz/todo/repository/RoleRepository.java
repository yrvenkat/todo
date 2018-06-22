package org.vrpowerz.todo.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.vrpowerz.todo.model.Role;

@Repository
public interface RoleRepository extends CassandraRepository<Role, UUID> {

}
