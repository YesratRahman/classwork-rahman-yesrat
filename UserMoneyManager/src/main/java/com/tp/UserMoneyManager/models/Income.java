package com.tp.UserMoneyManager.models;

import java.util.Date;

public class Income {
    Integer incomeId;
    Integer jobId;
    Integer userId;
    Double incomeAmount;
    String description;
    Date earnedDate;

    public Income(){

    }

    public Income(Integer incomeId, Integer jobId, Integer userId, Double incomeAmount, String description, Date earnedDate) {
        this.incomeId = incomeId;
        this.jobId = jobId;
        this.userId = userId;
        this.incomeAmount = incomeAmount;
        this.description = description;
        this.earnedDate = earnedDate;
    }

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return earnedDate;
    }

    public void setDate(Date date) {
        this.earnedDate = date;
    }

}
