package com.tp.UserMoneyManager.daos;

import com.tp.UserMoneyManager.daos.mappers.IntegerMapper;
import com.tp.UserMoneyManager.daos.mappers.UserMapper;
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
    public User addUser(User toAdd) {
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
    public User getAllUsersById(Integer userId) {
         User getUser = template.queryForObject("SELECT \"userId\", \"userName\" FROM \"Users\" WHERE \"userId\"='" + userId + "'", new UserMapper());
        return getUser;
    }


    @Override
    public List<User> getUsersByUserName(String userName) {
        List<User> users = template.query(
                "SELECT \"userId\", \"userName\" FROM \"Users\" WHERE \"userName\" = ?;",
                new UserMapper(), userName);

        return users;
    }

    @Override
    public int deleteUser(Integer userId) {
        int delete = template.update("DELETE FROM \"Users\" WHERE \"userId\" = ?;", userId);
        return delete;
    }

    @Override
    public int updateUser(Integer userId, User user) {
        int userUpdate = template.update("UPDATE \"Users\" " +
                "SET \"userName\" =?\n" +
                "WHERE \"userId\" = ?;\n" +
                "\n",
                user.getUserName(), userId);
            return userUpdate;
    }


}
