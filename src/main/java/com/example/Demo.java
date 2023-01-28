package com.example;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Demo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GlobalTransactional
    public void doWithGlobalTraction(String name) {
        // insert语句不包含主键列: id
        jdbcTemplate.update("insert into hello(name) values(?)", name);
    }
}
