package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * Hello world!
 */
@SpringBootApplication
@PropertySource({"classpath:config/seata.properties"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
