package org.vrpowerz.todo.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.vrpowerz.todo.model.Company;

@Repository
public interface CompanyRepository extends CassandraRepository<Company, UUID> {

}
