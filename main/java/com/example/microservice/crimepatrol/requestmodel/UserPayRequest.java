package com.example.microservice.crimepatrol.requestmodel;

public class UserPayRequest {
	
	private Long amount;

	public UserPayRequest(Long amount) {
		super();
		this.amount = amount;
	}
	public UserPayRequest(){
		super();
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
