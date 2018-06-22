package org.vrpowerz.todo.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("vrpowerz_todo_branches")
public class Branch extends CassandraModel{

	@Column("name")
	@Indexed
	private String Name;
	
	@Column("company")
	@Indexed
	private UUID Company;
	
	@Column("description")
	private String Description;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public UUID getCompany() {
		return Company;
	}

	public void setCompany(UUID company) {
		Company = company;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Branch(UUID id, Date timeStamp, @Indexed Set<String> tags, @Indexed String name, @Indexed UUID company,
			String description) {
		super(id, timeStamp, tags);
		Name = name;
		Company = company;
		Description = description;
	}
	
	
	
	
}
