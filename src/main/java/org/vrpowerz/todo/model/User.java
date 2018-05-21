/**
 * 
 */
package org.vrpowerz.todo.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
import org.vrpowerz.enums.Gender;

/**
 * @author Venkataraghavan Yanamandram Ramsubbu
 *
 */
@Table("vrpowerz_todo_users")
public class User {
	
	@PrimaryKey
	@Column("")
	private UUID id;
	private String username;
	private String password;
	private boolean enabled;
	private String firstname;
	private String lastname;
	private Gender gender;
	private String email;
	
	
	

}
