package com.example.microservice.crimepatrol.requestmodel;

public class GroupRequest {
	
	private String name;

	private String userName;

	public GroupRequest(String name, String userName) {
		super();
		this.name = name;
		this.userName = userName;
	}
	public GroupRequest(){
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
