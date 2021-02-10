package com.tp.UserMoneyManager.daos;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("daoTesting")
public class PostgresUserDaoTests {

    @Autowired
    UserPostgresDao toTest;

    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setUp(){
       // template.update("TRUNCATE ")
    }


}
