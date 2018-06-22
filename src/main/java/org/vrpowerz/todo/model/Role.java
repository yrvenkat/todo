package org.vrpowerz.todo.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("vrpowerz_todo_roles")
public class Role extends CassandraModel {
	
	@Column("role")
	@Indexed
	private String Role;
	
	@Column("rolekey")
	@Indexed
	private String RoleKey;
	
	@Column("description")
	private String Description;

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getRoleKey() {
		return RoleKey;
	}

	public void setRoleKey(String roleKey) {
		RoleKey = roleKey;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	public Role() { }

	public Role(UUID id, Date timeStamp, @Indexed Set<String> tags, @Indexed String role, @Indexed String roleKey,
			String description) {
		super(id, timeStamp, tags);
		Role = role;
		RoleKey = roleKey;
		Description = description;
	}
	
	
	
	
	
	
	
}
