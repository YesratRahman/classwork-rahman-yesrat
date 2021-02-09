package com.tp.UserMoneyManager.daos;

import com.tp.UserMoneyManager.models.User;

import java.util.List;

public interface UserDao {

   List<User> getAllUsers();
   User addUser(User toAdd);

}
