package com.tp.UserMoneyManager.daos;

import com.tp.UserMoneyManager.daos.mappers.IntegerMapper;
import com.tp.UserMoneyManager.daos.mappers.UserMapper;
import com.tp.UserMoneyManager.exceptions.InvalidUserIdException;
import com.tp.UserMoneyManager.exceptions.InvalidUserNameException;
import com.tp.UserMoneyManager.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Profile({"production", "daoTesting"})
public class UserPostgresDao implements UserDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public User addUser(User toAdd) throws InvalidUserNameException {
        if(toAdd == null ){
            throw new IllegalArgumentException("User can not be null!");
        }
        if(toAdd.getUserName() == null || toAdd.getUserName().isEmpty() || toAdd.getUserName().isBlank()){
            throw new InvalidUserNameException("User name can not be Invalid");
        }

        Integer userId= template.queryForObject("INSERT INTO \"Users\" (\"userName\") \n" +
                        "VALUES (?) RETURNING \"userId\";",
                new IntegerMapper("userId"),
                toAdd.getUserName()
        );
        toAdd.setUserId( userId );
        return toAdd;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = template.query("SELECT * FROM \"Users\"", new UserMapper());

        return allUsers;

    }

    @Override
    public User getAllUsersById(Integer userId) throws InvalidUserIdException {
        if(userId == null){
            throw new InvalidUserIdException("User id can not be null!");
        }
         User getUser = template.queryForObject("SELECT \"userId\", \"userName\" FROM \"Users\" WHERE \"userId\"='" + userId + "'", new UserMapper());
        return getUser;
    }


    @Override
    public List<User> getUsersByUserName(String userName) throws InvalidUserNameException {
        if(userName == null || userName.isEmpty() || userName.isBlank()){
            throw new InvalidUserNameException("User name can not be Invalid");
        }
        List<User> users = template.query(
                "SELECT \"userId\", \"userName\" FROM \"Users\" WHERE \"userName\" = ?;",
                new UserMapper(), userName);

        return users;
    }

    @Override
    public int deleteUser(Integer userId) throws InvalidUserIdException {
        if(userId == null){
            throw new InvalidUserIdException("User id can not be null!");
        }
        int delete = template.update("DELETE FROM \"Users\" WHERE \"userId\" = ?;", userId);
        return delete;
    }

    @Override
    public int updateUser(Integer userId, User user) throws InvalidUserIdException {
        if(userId == null){
            throw new InvalidUserIdException("User id can not be null!");
        }
        int userUpdate = template.update("UPDATE \"Users\" " +
                "SET \"userName\" =?\n" +
                "WHERE \"userId\" = ?;",
                user.getUserName(), userId);
            return userUpdate;
    }


}
