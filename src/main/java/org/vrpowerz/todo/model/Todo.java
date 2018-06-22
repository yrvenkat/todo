package org.vrpowerz.todo.model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

public class Todo extends CassandraModel {

	@Column("todo")
	private String Todo;
	
	@Column("datetime")
	@Indexed
	private Date DateTime;
	
	@Column("company")
	@Indexed
	private UUID Company;
	
	@Column("from")
	@Indexed
	private UUID From;
	
	@Column("to")
	@Indexed
	private UUID To;
	
	@Column("is_completed")
	@Indexed
	private boolean Completed;
	
	

	public String getTodo() {
		return Todo;
	}



	public void setTodo(String todo) {
		Todo = todo;
	}



	public Date getDateTime() {
		return DateTime;
	}



	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}



	public UUID getCompany() {
		return Company;
	}



	public void setCompany(UUID company) {
		Company = company;
	}



	public UUID getFrom() {
		return From;
	}



	public void setFrom(UUID from) {
		From = from;
	}



	public UUID getTo() {
		return To;
	}



	public void setTo(UUID to) {
		To = to;
	}



	public boolean isCompleted() {
		return Completed;
	}



	public void setCompleted(boolean completed) {
		Completed = completed;
	}



	public Todo(UUID id, Date timeStamp, @Indexed Set<String> tags, String todo, @Indexed Date dateTime,
			@Indexed UUID company, @Indexed UUID from, @Indexed UUID to, @Indexed boolean completed) {
		super(id, timeStamp, tags);
		Todo = todo;
		DateTime = dateTime;
		Company = company;
		From = from;
		To = to;
		Completed = completed;
	}
	
	
}
