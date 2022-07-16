package com.example.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class JdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> getPersons(){
        return jdbcTemplate.query("select * from jpatable1",new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person getById(String name){
        return jdbcTemplate.queryForObject
                ("select * from jpatable1 where name=?",new Object[]{name},
                        new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteId(int id){
        return jdbcTemplate.update("delete from jpatable1 where id=?",new Object[]{id});
    }


    public int inser(Person person){

        return jdbcTemplate.update("insert into jpatable1 values  (?,?,?,?)" ,
                new Object[]{
                        person.getId(),
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(
                                person.getBirth_date().getTime()
                        )});
    }

}
