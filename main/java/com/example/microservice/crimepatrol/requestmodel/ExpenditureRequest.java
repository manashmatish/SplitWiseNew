package com.example.microservice.crimepatrol.requestmodel;

public class ExpenditureRequest {

    private String groupName;

    private String userUid;

    private Long amount;

    private String name;

    public ExpenditureRequest(String groupName, String userUid, Long amount, String name) {
        super();
        this.groupName = groupName;
        this.userUid = userUid;
        this.amount = amount;
        this.name = name;
    }

    public ExpenditureRequest() {
        super();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUids(String userUid) {
        this.userUid = userUid;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
