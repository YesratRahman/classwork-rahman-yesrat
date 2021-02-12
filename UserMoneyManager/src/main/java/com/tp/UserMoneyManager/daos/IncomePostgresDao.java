package com.tp.UserMoneyManager.daos;

import com.tp.UserMoneyManager.models.Income;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile({"production", "daoTesting"})

public class IncomePostgresDao implements IncomeDao {
    @Override
    public Income addIncome(Income toAdd) {
        return null;
    }

    @Override
    public List<Income> getAllIncomes() {
        return null;
    }

    @Override
    public Income getAllIncomeById() {
        return null;
    }

    @Override
    public List<Income> getIncomeByAmount() {
        return null;
    }

    @Override
    public List<Income> getIncomeByDate() {
        return null;
    }

    @Override
    public int updateIncome() {
        return 0;
    }

    @Override
    public int deleteIncome() {
        return 0;
    }
}
