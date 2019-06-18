package com.example.microservice.crimepatrol.db;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {

	public Users(String name, String address, String displayName) {
		this.name=name;
		this.address=address;
		this.displayName=displayName;
	}
	
	public Users() {
		super();
	}

	@Id
	@Column( name = "uuid" )
	@GeneratedValue	
	private Long uuid;
	
	private String name;
	
	private String address;
	
	private String displayName;
	
	private Calendar createdDate;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

}
