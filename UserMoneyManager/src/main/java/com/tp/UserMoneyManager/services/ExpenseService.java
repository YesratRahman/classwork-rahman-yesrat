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
public class ExpenseService {
    @Autowired
    ExpenseDao expenseDao;

    public Expense addExpense(Expense toAdd) {
        throw new UnsupportedOperationException();
    }

    public List<Expense> getAllExpenses() {
        throw new UnsupportedOperationException();
    }

    public Expense getAllExpenseById(Integer expenseId) throws InvalidExpenseIdException {
        throw new UnsupportedOperationException();

    }

    public List<Expense> getExpenseByAmount(Double expenseAmount) throws InvalidExpenseException {
        throw new UnsupportedOperationException();

    }

    public List<Expense> getExpenseByDate(Date spentDate) throws InvalidExpenseException {
        throw new UnsupportedOperationException();

    }

    public int updateExpense(Integer expenseId, Expense expense) throws InvalidExpenseIdException {
        throw new UnsupportedOperationException();

    }

    public int deleteExpense(Integer expenseId) throws InvalidExpenseIdException{
        throw new UnsupportedOperationException();

    }
}
