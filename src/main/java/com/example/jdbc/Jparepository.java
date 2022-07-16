package com.example.jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class Jparepository  {

    //Connect database
    @PersistenceContext
    EntityManager entityManager;
    public Person findById( int id){
         return entityManager.find(Person.class,id);
     }
     public Person insert(Person person){
        return entityManager.merge(person);
     }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public void remove(int id){
        Person person = findById(id);
         entityManager.remove(person);
    }

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_persons",Person.class);
        return namedQuery.getResultList();
    }
    
    
}
