package com.tp.UserMoneyManager.daos;

import com.tp.UserMoneyManager.exceptions.InvalidUserNameException;
import com.tp.UserMoneyManager.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("daoTesting")
public class PostgresUserDaoTests {

    @Autowired
    UserPostgresDao toTest;

    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setUp(){
        template.update("TRUNCATE \"IncomeReports\", \"ExpenseReports\", \"Reports\", \"Expenses\", \"Incomes\", \"Jobs\", \"Users\" RESTART IDENTITY; \n");
//        template.update("INSERT INTO \"Users\" (\"userName\") VALUES ('Yesrat')");
//        template.update("INSERT INTO \"Users\" (\"userName\") VALUES ('Eliot')");
//        template.update("INSERT INTO \"Users\" (\"userName\") VALUES ('Eliot2')");


    }

    @Test
    public void addUserGoldenPathTest() throws InvalidUserNameException {
        User user = new User();
        user.setUserName("Raha");



        User newUser = toTest.addUser(user);
        //assertEquals(3, newUser.getUserId());
        //assertEquals("Raha", user.getUserName());

        List<User> allUsers = toTest.getAllUsers();

       // assertEquals(1, allUsers.get(0).getUserId());
        //assertEquals("Yesrat", allUsers.get(0).getUserName());
        //assertEquals("Raha", allUsers.get(1).getUserName());

    }


}
