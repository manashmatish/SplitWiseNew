package com.example.microservice.crimepatrol.db;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SplitDetails {

    @Id
    @GeneratedValue
    private Long uuid;

    private String expenditureName;

    private String userName;

    private Long amountReceived;
    
    private Long amountRemaining;

    private Calendar createdDate;

    public SplitDetails(String expenditureName, String userName, Long amountReceived, Long amountRemaining) {
        super();
        this.expenditureName = expenditureName;
        this.userName = userName;
        this.amountReceived = amountReceived;
        this.amountRemaining = amountRemaining;
    }

    public SplitDetails() {
        super();
    }

    public Long getUuid() {
        return uuid;
    }

    public void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getExpenditureName() {
        return expenditureName;
    }

    public void setExpenditureName(String expenditureUuid) {
        this.expenditureName = expenditureUuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(Long amountReceived) {
        this.amountReceived = amountReceived;
    }

    public Long getAmountRemaining() {
        return amountRemaining;
    }

    public void setAmountRemaining(Long amountRemaining) {
        this.amountRemaining = amountRemaining;
    }

    public Calendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }
}
