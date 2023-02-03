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
        /*
         * 单主键场景
         * 表: single
         * 列: id, name
         * 主键: id
         */
        // insert columns为空
        jdbcTemplate.update("insert into hello values(1, ?)", name);
        // insert columns包含主键
        jdbcTemplate.update("insert into hello(id, name) values(2, ?)", name);
        // insert columns不是空, 且不包含主键
        jdbcTemplate.update("insert into hello(name) values(?)", name);

        /*
         * 多主键场景
         * 表: multi
         * 列: id1, id2, name
         * 联合主键: (id1, id2)
         */
        // insert columns为空
        jdbcTemplate.update("insert into multi values(1, 1, ?)", name);
        // insert columns包含全部主键
        jdbcTemplate.update("insert into multi(id1, id2, name) values(2, 2, ?)", name);
        // insert columns包含部分主键
        jdbcTemplate.update("insert into multi(id1, name) values(3, ?)", name);
        jdbcTemplate.update("insert into multi(id2, name) values(4, ?)", name);
        // insert columns不是空, 且不包含主键
        jdbcTemplate.update("insert into multi(name) values(?)", name);


        // insert columns为空
        jdbcTemplate.update("insert into multi2 values(1, 1, ?)", name);
        // insert columns包含全部主键
        jdbcTemplate.update("insert into multi2(id1, id2, name) values(2, 2, ?)", name);
        // insert columns包含部分主键
        jdbcTemplate.update("insert into multi2(id1, name) values(3, ?)", name);
        jdbcTemplate.update("insert into multi2(id2, name) values(4, ?)", name);
        // insert columns不是空, 且不包含主键
        jdbcTemplate.update("insert into multi2(name) values(?)", name);

    }
}
