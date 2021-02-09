package com.tp.UserMoneyManager.services;

import com.tp.UserMoneyManager.daos.ExpenseDao;
import com.tp.UserMoneyManager.daos.IncomeDao;
import com.tp.UserMoneyManager.daos.UserDao;
import com.tp.UserMoneyManager.daos.UserPostgresDao;
import com.tp.UserMoneyManager.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MoneyManagerService {
    @Autowired
    UserDao userDao;



    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User addUser(User toAdd){

        //TODO: Some Cases
        return userDao.addUser(toAdd);
    }
}
