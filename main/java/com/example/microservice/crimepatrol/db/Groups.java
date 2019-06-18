package com.example.microservice.crimepatrol.db;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity	
public class Groups {

	public Groups() {
		super();
	}

	@Id
	@GeneratedValue
	private Long uuid;
	
	private String name;

	
	private String users;
	
	private Calendar createdDate;
	
	public Groups(String name, String users) {
		super();
		this.name = name;
		this.users = users;
	}

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String userUuid) {
		this.users = userUuid;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

}
