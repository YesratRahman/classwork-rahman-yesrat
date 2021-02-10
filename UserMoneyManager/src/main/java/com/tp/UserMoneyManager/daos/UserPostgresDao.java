package com.tp.UserMoneyManager.daos;

import com.tp.UserMoneyManager.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserPostgresDao implements UserDao {

    @Autowired
    JdbcTemplate template;

    @Override
    public User addUser(User toAdd) {
        Integer userId= template.queryForObject("INSERT INTO \"Users\" (\"userName\") \n" +
                        "VALUES (?) RETURNING \"userId\";",
                new UserIdMapper(),
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
                "SELECT \"userId\", \"userName\" FROM \"Users\" WHERE \"userName\" = 'userName';",
                new UserMapper());

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


    class UserMapper implements RowMapper<User>{
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException{
            User mappedUser = new User();
            mappedUser.setUserId(resultSet.getInt("userId"));
            mappedUser.setUserName(resultSet.getString("userName"));
            return mappedUser;
        }
    }

    class UserIdMapper implements RowMapper<Integer>{

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("userId");
        }
    }
}
