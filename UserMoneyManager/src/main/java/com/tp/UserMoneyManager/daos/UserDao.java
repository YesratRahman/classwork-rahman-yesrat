package com.tp.UserMoneyManager.daos;

import com.tp.UserMoneyManager.models.User;

import java.util.List;

public interface UserDao {

   User addUser(User toAdd);
   List<User> getAllUsers();
   User getAllUsersById(Integer userId);
   List<User> getUsersByUserName(String userName);
   int updateUser(Integer userId, User user);
   int deleteUser(Integer userId);
}
