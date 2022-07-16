package com.example.jdbc;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.function.Supplier;
import java.util.logging.Logger;

@SpringBootApplication
public class JpaDemo implements CommandLineRunner {
    @Autowired
    Jparepository jparepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaDemo.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(jparepository.findById(1));
        jparepository.insert(new Person(2,"jpa1","texas",new Date()));
        jparepository.update(new Person(1,"hibernate","texas",new Date()));
        //jparepository.remove(2);
        jparepository.findAll();
    }
}

