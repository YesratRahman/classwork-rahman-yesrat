package com.tp.UserMoneyManager.models;

import java.util.Date;

public class Expense {
    Integer expenseId;
    Double expenseAmount;
    String description;
    Date spentDate;
    Integer userId;
    Integer jobId;

    public Expense(){

    }
    public Expense(Integer expenseId, Integer jobId, Integer userId, Double expenseAmount, String description, Date spentDate){
        this.expenseId = expenseId;
        this.jobId = jobId;
        this.userId = userId;
        this.expenseAmount = expenseAmount;
        this.description = description;
        this.spentDate = spentDate;

    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public Double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getSpentDate() {
        return spentDate;
    }

    public void setSpentDate(Date spentDate) {
        this.spentDate = spentDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
}
