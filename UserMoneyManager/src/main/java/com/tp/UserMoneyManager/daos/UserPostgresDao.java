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
    public List<User> getAllUsers() {
        return null;

    }

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
