package com.example.speaking.repository;

import com.example.speaking.model.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository <Person,String> {


}
