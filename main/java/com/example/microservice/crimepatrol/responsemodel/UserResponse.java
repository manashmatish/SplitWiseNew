package com.example.microservice.crimepatrol.responsemodel;

import java.util.Calendar;

public class UserResponse {
	private String uuid;

	private String name;

	private String address;

	private String displayName;

	private Calendar createdDate;

	public UserResponse(String uuid, String name, String address, String displayName, Calendar createdDate) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.address = address;
		this.displayName = displayName;
		this.createdDate = createdDate;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
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
