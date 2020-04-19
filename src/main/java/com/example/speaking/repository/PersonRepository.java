package com.example.speaking.repository;

import com.example.speaking.model.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface PersonRepository extends MongoRepository <Person,String> {

    @Query ("{'firstName' : ?0}")
    List<Person> findByName(String firstName);
    Person findByEmailAndPassword(String email,String password);


}

