package com.tp.UserMoneyManager.daos;

import com.tp.UserMoneyManager.models.Expense;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

@Profile({"production", "daoTesting"})
public class ExpensePostgresDao implements ExpenseDao {
    @Override
    public Expense addExpense() {
        return null;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return null;
    }

    @Override
    public Expense getAllExpenseById() {
        return null;
    }

    @Override
    public List<Expense> getExpenseByAmount() {
        return null;
    }

    @Override
    public List<Expense> getExpenseByDate() {
        return null;
    }

    @Override
    public int updateExpense() {
        return 0;
    }

    @Override
    public int deleteExpense() {
        return 0;
    }
}
