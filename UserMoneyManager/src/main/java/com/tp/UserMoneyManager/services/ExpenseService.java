package com.tp.UserMoneyManager.services;

import com.tp.UserMoneyManager.daos.ExpenseDao;
import com.tp.UserMoneyManager.exceptions.InvalidExpenseException;
import com.tp.UserMoneyManager.exceptions.InvalidExpenseIdException;
import com.tp.UserMoneyManager.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ExpenseService  {
    @Autowired
    ExpenseDao expenseDao;

    public Expense addExpense(Expense toAdd) {
    return expenseDao.addExpense();
    }

    public List<Expense> getAllExpenses() {
        return expenseDao.getAllExpenses();     }

    public Expense getAllExpenseById(Integer expenseId) throws InvalidExpenseIdException {
        return expenseDao.getAllExpenseById();
    }

    public List<Expense> getExpenseByAmount(Double expenseAmount) throws InvalidExpenseException {
        return expenseDao.getExpenseByAmount();
    }

    public List<Expense> getExpenseByDate(Date spentDate) throws InvalidExpenseException {
        return expenseDao.getExpenseByDate();

    }

    public int updateExpense(Integer expenseId, Expense expense) throws InvalidExpenseIdException {
        return expenseDao.updateExpense();

    }

    public int deleteExpense(Integer expenseId) throws InvalidExpenseIdException{
        return expenseDao.deleteExpense();
    }

}
