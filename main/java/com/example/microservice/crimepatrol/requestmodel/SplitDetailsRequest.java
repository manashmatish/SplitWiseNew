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
        private String userUuid;
        
        private Long amount;

        public String getUserUuid() {
            return userUuid;
        }

        public void setUserUuid(String userUuid) {
            this.userUuid = userUuid;
        }

        public Long getAmount() {
            return amount;
        }

        public void setAmount(Long amount) {
            this.amount = amount;
        }
    }

}
