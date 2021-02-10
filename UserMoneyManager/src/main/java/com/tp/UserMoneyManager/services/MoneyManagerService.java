package com.tp.UserMoneyManager.services;

import com.tp.UserMoneyManager.daos.ExpenseDao;
import com.tp.UserMoneyManager.daos.IncomeDao;
import com.tp.UserMoneyManager.daos.UserDao;
import com.tp.UserMoneyManager.daos.UserPostgresDao;
import com.tp.UserMoneyManager.exceptions.InvalidUserIdException;
import com.tp.UserMoneyManager.exceptions.InvalidUserNameException;
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

        if(toAdd == null){
            throw new IllegalArgumentException("User can not be null!");
        }
        return userDao.addUser(toAdd);
    }

    public User getAllUsersById(Integer userId) throws InvalidUserIdException {
        if(userId == null){
            throw new InvalidUserIdException("User Id can not be null!");
        }
        return userDao.getAllUsersById(userId);

    }

    public List<User> getUsersByUserName(String userName) throws InvalidUserNameException {
        if(userName == null || userName.isEmpty() || userName.isBlank()){
            throw new InvalidUserNameException("UserName is invalid!");
        }
        return userDao.getUsersByUserName(userName);
    }


    public int updateUser(Integer userId, User user) throws InvalidUserIdException {
        if(userId == null){
            throw new InvalidUserIdException("User Id can not be null!");
        }
        if(user == null){
            throw new IllegalArgumentException("User can not be null!");
        }
        return userDao.updateUser(userId, user);
    }


    public int deleteUser(Integer userId) throws InvalidUserIdException {
        if(userId == null){
            throw new InvalidUserIdException("User Id can not be null!");
        }
         return userDao.deleteUser(userId);
    }


}
