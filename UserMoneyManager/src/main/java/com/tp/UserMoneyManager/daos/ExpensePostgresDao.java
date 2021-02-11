package com.tp.UserMoneyManager.daos;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component

@Profile({"production", "daoTesting"})
public class ExpensePostgresDao implements ExpenseDao {
}
