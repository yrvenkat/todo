package org.vrpowerz.todo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Venkataraghavan Yanamandram Ramasubbu
 *
 */

@Component
@PropertySource(value={"classpath:cassandra.properties"})
public class CassandraConnection {
	
	@Autowired
	private Environment env;
	
	
	public String getKeySpace(){
		return env.getProperty("cassandra.keyspace");
	}
	
	public String getConnectPoints(){
		return env.getProperty("cassandra.contactpoints");
	}
	
	public int getPort(){
		return Integer.parseInt(env.getProperty("cassandra.port"));
	}
	

}
