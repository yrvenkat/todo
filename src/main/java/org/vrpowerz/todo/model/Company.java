package org.vrpowerz.todo.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("vrpowerz_todo_company")
public class Company extends CassandraModel{
	

	@Column("name")
	@Indexed
	private String Name;
	
	@Column("address")
	private String Address;
	
	@Column("description")
	private String Description;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	public Company(){ }

	public Company(UUID id, @Indexed String name, String address, String description, Date timeStamp,
			Set<String> tags) {
		super(id, timeStamp, tags);
		Name = name;
		Address = address;
		Description = description;
	}
	
	

}
