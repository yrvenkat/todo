package org.vrpowerz.todo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import com.datastax.driver.core.utils.UUIDs;

public class CassandraModel implements Serializable {


	@PrimaryKey
	protected UUID id;
	
	@Column("timestamp")
	protected Date TimeStamp;
	
	@Column("tags")
	@Indexed
	protected Set<String> Tags = new HashSet<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		TimeStamp = timeStamp;
	}

	public Set<String> getTags() {
		return Tags;
	}

	public void setTags(Set<String> tags) {
		Tags = tags;
	}
	
	public CassandraModel() { }

	public CassandraModel(UUID id, Date timeStamp, @Indexed Set<String> tags) {
		super();
		this.id = (id == null) ? UUIDs.timeBased() : id;
		TimeStamp = timeStamp;
		Tags = tags;
	}
	
	
}
