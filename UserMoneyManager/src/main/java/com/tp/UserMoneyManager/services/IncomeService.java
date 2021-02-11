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

       return incomeDao.addIncome(toAdd);
    }

    public List<Income> getAllIncomes() {

        return incomeDao.getAllIncomes();
    }

    public Income getAllIncomeById(Integer incomeId) throws InvalidIncomeIdException {

        return incomeDao.getAllIncomeById();
    }

    public List<Income> getIncomeByAmount(Double incomeAmount) throws InvalidIncomeException {
        return incomeDao.getIncomeByAmount();
    }

    public List<Income> getIncomeByDate(Date earnedDate) throws InvalidIncomeException {
        return incomeDao.getIncomeByDate();
    }

    public int updateIncome(Integer incomeId, Income income) throws InvalidIncomeIdException {
        return incomeDao.updateIncome();
    }

    public int deleteIncome(Integer incomeId) throws InvalidIncomeIdException{
        return incomeDao.deleteIncome();

    }
}
