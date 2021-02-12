package com.tp.UserMoneyManager.models;

import java.util.Date;

public class Income {
    Integer incomeId;
    Integer userId;
    Double incomeAmount;
    String description;
    Date earnedDate;

    public Income(){

    }

    public Income(Integer incomeId, Integer userId, Double incomeAmount, String description, Date earnedDate) {
        this.incomeId = incomeId;
        this.userId = userId;
        this.incomeAmount = incomeAmount;
        this.description = description;
        this.earnedDate = earnedDate;
    }

    public Date getEarnedDate() {
        return earnedDate;
    }

    public void setEarnedDate(Date earnedDate) {
        this.earnedDate = earnedDate;
    }

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
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



}
