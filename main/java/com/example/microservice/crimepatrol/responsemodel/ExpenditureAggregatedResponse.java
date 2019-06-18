package com.example.microservice.crimepatrol.responsemodel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExpenditureAggregatedResponse {    

    private String name;

    private Calendar createdDate;
    
    private Long totalAmount;
    
    private String owner;

    private List<Split> split = new ArrayList<>();
    
    public ExpenditureAggregatedResponse( ) {
        super();
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
    
    public List<Split> getSplit() {
        return split;
    }

    public void setSplit(List<Split> split) {
        this.split = split;
    }
    
    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public static class Split {

        private String userName;

        private Long amountPaid;

        private Long amountRemaining;

        public Split() {
            super();
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Long getAmountPaid() {
            return amountPaid;
        }

        public void setAmountPaid(Long amountPaid) {
            this.amountPaid = amountPaid;
        }

        public Long getAmountRemaining() {
            return amountRemaining;
        }

        public void setAmountRemaining(Long amountRemaining) {
            this.amountRemaining = amountRemaining;
        }

    }


}
