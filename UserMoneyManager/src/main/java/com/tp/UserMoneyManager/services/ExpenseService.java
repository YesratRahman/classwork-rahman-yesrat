package com.tp.UserMoneyManager.services;

import com.tp.UserMoneyManager.daos.ExpenseDao;
import com.tp.UserMoneyManager.exceptions.InvalidExpenseException;
import com.tp.UserMoneyManager.exceptions.InvalidExpenseIdException;
import com.tp.UserMoneyManager.exceptions.InvalidUserIdException;
import com.tp.UserMoneyManager.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ExpenseService  {
    @Autowired
    ExpenseDao expenseDao;

    public Expense addExpense(Expense toAdd) throws InvalidUserIdException, InvalidExpenseException, InvalidExpenseIdException {
        if(toAdd == null){
            throw new InvalidExpenseException("Expense can not be null!");
        }
        return expenseDao.addExpense(toAdd);
    }

    public List<Expense> getAllExpenses() {
        return expenseDao.getAllExpenses();
    }

    public Expense getAllExpenseById(Integer expenseId) throws InvalidExpenseIdException {
        if(expenseId == null){
            throw new InvalidExpenseIdException("Expense Id can not be null!");
        }
        return expenseDao.getAllExpenseById(expenseId);
    }


    public List<Expense> getExpenseByDate(LocalDate spentDate) throws InvalidExpenseException {
       if(spentDate == null){
           throw new InvalidExpenseException("Date can not be null");
       }
        return expenseDao.getExpenseByDate(spentDate);

    }

    public int updateExpense(Integer expenseId, Expense expense) throws InvalidExpenseIdException, InvalidExpenseException {
        if(expenseId == null){
            throw new InvalidExpenseIdException("Expense Id can not be null");
        }
        if(expense == null){
            throw new InvalidExpenseException("Expense object can not be null!");
        }
        return expenseDao.updateExpense();

    }

    public int deleteExpense(Integer expenseId) throws InvalidExpenseIdException{
        if(expenseId == null){
            throw new InvalidExpenseIdException("Expense Id can not be null");
        }
        return expenseDao.deleteExpense();
    }

    //    public List<Expense> getExpenseByAmount(Double expenseAmount) throws InvalidExpenseException {
    //        if(expenseAmount == null){
    //            throw new InvalidExpenseException("Expense amount can not be null");
    //        }
    //        return expenseDao.getExpenseByAmount();
    //    }

}
