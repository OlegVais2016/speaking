package com.example.speaking.repository;

import com.example.speaking.model.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface PersonRepository extends MongoRepository <Person,String> {

    @Query ("{'firstName' : ?0}")
    Person findByName(String firstName);
    Person findByEmailAndPassword(String email,String password);


}

