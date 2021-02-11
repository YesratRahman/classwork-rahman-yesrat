package com.tp.UserMoneyManager.daos;


import com.tp.UserMoneyManager.models.Income;

import java.util.List;

public interface IncomeDao {

    Income addIncome(Income toAdd);
    List<Income> getAllIncomes();
    Income getAllIncomeById();

    List<Income> getIncomeByAmount();

    List<Income> getIncomeByDate();

    int updateIncome();

    int deleteIncome();
}
