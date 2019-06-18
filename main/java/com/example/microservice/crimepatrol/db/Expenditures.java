package com.example.microservice.crimepatrol.db;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Expenditures {

	@Id
	@GeneratedValue
	private Long uuid;

	private String groupName;

	private Long amount;
	
	private String userName;
	
	private String name;

	private Calendar createdDate;

	public Expenditures(String groupName, Long amount, String userName, String name) {
		super();
		this.groupName = groupName;
		this.amount = amount;
		this.userName = userName;
		this.name = name;
	}
	
	public Expenditures() {
		super();
	}

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}


}
