package com.example.microservice.crimepatrol.requestmodel;

public class UserRequest {
	
	private String name;

	private String address;

	private String displayName;

	public UserRequest(String name, String address, String displayName) {
		super();
		this.name = name;
		this.address = address;
		this.displayName = displayName;
	}
	public UserRequest(){
		//
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
}
