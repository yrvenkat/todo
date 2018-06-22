package org.vrpowerz.todo.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraCqlClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DataCenterReplication;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;



/**
 * @author Venkataraghavan Yanamandram Ramasubbu
 *
 */

@Configuration
@ConfigurationProperties("spring.data.cassandra")
@EnableCassandraRepositories(basePackages="org.vrpowerz.todo.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Autowired
	private CassandraConnection con;
	
//	@Bean
//	public CassandraClusterFactoryBean cluster(){
//		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
//		cluster.setContactPoints(con.getConnectPoints());
//		cluster.setPort(con.getPort());
//		return cluster;
//	}
	
	@Override
	public CassandraCqlClusterFactoryBean cluster() {
		CassandraCqlClusterFactoryBean bean = new CassandraCqlClusterFactoryBean();
		bean.setKeyspaceCreations(getKeyspaceCreations());
		bean.setContactPoints(con.getConnectPoints());
		bean.setPort(con.getPort());
		return bean;
	}
	
	@Bean
	public CassandraMappingContext mappingContext(){
		return new CassandraMappingContext();
	}
	
	@Bean
	public CassandraConverter converter(){
		return new MappingCassandraConverter(mappingContext());
	}
	
//	@Bean
//	public CassandraSessionFactoryBean session(){
//		CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
//		session.setCluster(cluster().getObject());
//		session.setKeyspaceName(con.getKeySpace());
//		session.setConverter(converter());
//		session.setSchemaAction(SchemaAction.CREATE_IF_NOT_EXISTS);
//		return session;
//	}
	
//	public CassandraOperations cassandraTemplate() throws Exception{
//		return new CassandraTemplate(session().getObject());
//	}

	@Override
	protected String getKeyspaceName() {
		return con.getKeySpace();
	}
	
	@Override
	public SchemaAction getSchemaAction() {
		return SchemaAction.CREATE_IF_NOT_EXISTS;
	}
	
	@Override
	public String[] getEntityBasePackages() {
		return new String[]{"org.vrpowerz.todo.model"};
	}
	
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        List<CreateKeyspaceSpecification> createKeyspaceSpecifications = new ArrayList<>();
        createKeyspaceSpecifications.add(getKeySpaceSpecification());
        return createKeyspaceSpecifications;
    }

    // Below method creates "my_keyspace" if it doesnt exist.
    private CreateKeyspaceSpecification getKeySpaceSpecification() {
        CreateKeyspaceSpecification pandaCoopKeyspace =  CreateKeyspaceSpecification.createKeyspace("todos");
        DataCenterReplication dcr = DataCenterReplication.of("dc1", 3L);   
        //pandaCoopKeyspace.ifNotExists(true);
		CreateKeyspaceSpecification.createKeyspace("todos").withNetworkReplication(dcr);
        return pandaCoopKeyspace;
    }
	
}
