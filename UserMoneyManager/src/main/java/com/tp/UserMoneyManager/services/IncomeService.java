package com.tp.UserMoneyManager.services;

import com.tp.UserMoneyManager.daos.IncomeDao;
import com.tp.UserMoneyManager.exceptions.InvalidIncomeException;
import com.tp.UserMoneyManager.exceptions.InvalidIncomeIdException;
import com.tp.UserMoneyManager.models.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class IncomeService {

    @Autowired
    IncomeDao incomeDao;

    public Income addIncome(Income toAdd) {
        throw new UnsupportedOperationException();

    }

    public List<Income> getAllIncomes() {
        throw new UnsupportedOperationException();

    }

    public Income getAllIncomeById(Integer incomeId) throws InvalidIncomeIdException {
        throw new UnsupportedOperationException();

    }

    public List<Income> getIncomeByAmount(Double incomeAmount) throws InvalidIncomeException {
        throw new UnsupportedOperationException();

    }

    public List<Income> getIncomeByDate(Date earnedDate) throws InvalidIncomeException {
        throw new UnsupportedOperationException();

    }

    public int updateIncome(Integer incomeId, Income income) throws InvalidIncomeIdException {
        throw new UnsupportedOperationException();

    }

    public int deleteIncome(Integer incomeId) throws InvalidIncomeIdException{
        throw new UnsupportedOperationException();

    }
}
