/**
 * 
 */
package org.vrpowerz.todo.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.vrpowerz.todo.enums.Gender;


/**
 * @author Venkataraghavan Yanamandram Ramasubbu
 *
 */
@Table("vrpowerz_todo_users")
public class User extends CassandraModel {

	@Column("username")
	@Indexed
	private String username;
	
	@Column("password")
	private String Password;
	
	@Column("firstname")
	private String Firstname;
	
	@Column("lastname")
	private String Lastname;
	
	@Column("gender")
	private Gender Gender;
	
	@Column("email")
	@Indexed
	private String Email;
	
	@Column("mobile")
	private String Mobile;
	
	@Column("enabled")
	private boolean Enabled;
	
	@Column("role")
	@Indexed
	private UUID UserRole;
	
	@Column("company")
	@Indexed
	private UUID Company;


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getFirstname() {
		return Firstname;
	}


	public void setFirstname(String firstname) {
		Firstname = firstname;
	}


	public String getLastname() {
		return Lastname;
	}


	public void setLastname(String lastname) {
		Lastname = lastname;
	}


	public Gender getGender() {
		return Gender;
	}


	public void setGender(Gender gender) {
		Gender = gender;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getMobile() {
		return Mobile;
	}


	public void setMobile(String mobile) {
		Mobile = mobile;
	}


	public boolean isEnabled() {
		return Enabled;
	}


	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}


	public UUID getUserRole() {
		return UserRole;
	}


	public void setUserRole(UUID userRole) {
		UserRole = userRole;
	}
	

	public UUID getCompany() {
		return Company;
	}


	public void setCompany(UUID company) {
		Company = company;
	}


	public User(){ }


	public User(UUID id, Date timeStamp, @Indexed Set<String> tags, @Indexed String username, @Indexed String password,
			String firstname, String lastname, org.vrpowerz.todo.enums.Gender gender, @Indexed String email,
			String mobile, boolean enabled, @Indexed UUID userRole, @Indexed UUID company) {
		super(id, timeStamp, tags);
		this.username = username;
		Password = password;
		Firstname = firstname;
		Lastname = lastname;
		Gender = gender;
		Email = email;
		Mobile = mobile;
		Enabled = enabled;
		UserRole = userRole;
		Company = company;
	}



}
