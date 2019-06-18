package com.example.microservice.crimepatrol.requestmodel;

import java.util.ArrayList;
import java.util.List;

public class SplitDetailsRequest {

    private String expenditureName;

    
    private List<Split> userSplits = new ArrayList<Split>();

    public SplitDetailsRequest() {
        super();
    }

    public String getExpenditureName() {
        return expenditureName;
    }

    public void setExpenditureName(String expenditureName) {
        this.expenditureName = expenditureName;
    }

    public List<Split> getUserSplit() {
        return userSplits;
    }

    public void setUserSplit(List<Split> userSplit) {
        this.userSplits = userSplit;
    }
    
    public static class Split{
        private String userName;
        
        private Long amount;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }
    }

}
