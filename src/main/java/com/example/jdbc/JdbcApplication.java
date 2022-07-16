package com.example.jdbc;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.function.Supplier;
import java.util.logging.Logger;

//@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {
        //private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
        @Autowired
    JdbcRepository jdbcRepository;
    public static void main(String[] args) {
        SpringApplication.run(JdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(jdbcRepository.getPersons().toString());
//        //jdbcRepository.deleteId(1);
//        jdbcRepository.inser(new Person(1,"jpa","texas",new Date()));
    }
}
