package com.tp.UserMoneyManager.daos;

import com.tp.UserMoneyManager.models.Expense;

import java.util.List;

public interface ExpenseDao {
    Expense addExpense();

    List<Expense> getAllExpenses();

    Expense getAllExpenseById();

    List<Expense> getExpenseByAmount();

    List<Expense> getExpenseByDate();

    int updateExpense();

    int deleteExpense();
}
