package org.vrpowerz.todo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

@Configuration
public class CassandraConfig {
	
	@Autowired
	private CassandraConnection con;
	
	@Bean
	public CassandraClusterFactoryBean cluster(){
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(con.getConnectPoints());
		cluster.setPort(con.getPort());
		return cluster;
	}
	
	@Bean
	public CassandraMappingContext mappingContext(){
		return new BasicCassandraMappingContext();
	}
	
	@Bean
	public CassandraConverter converter(){
		return new MappingCassandraConverter(mappingContext());
	}
	
	@Bean
	public CassandraSessionFactoryBean session(){
		CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
		session.setCluster(cluster().getObject());
		session.setKeyspaceName(con.getKeySpace());
		session.setConverter(converter());
		session.setSchemaAction(SchemaAction.CREATE_IF_NOT_EXISTS);
		return session;
	}
	
	public CassandraOperations cassandraTemplate() throws Exception{
		return new CassandraTemplate(session().getObject());
	}

}