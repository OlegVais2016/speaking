package com.example.speaking.service.impl;

import com.example.speaking.model.dto.reg.RegPersonRequest;
import com.example.speaking.model.dto.reg.RegPersonResponse;
import com.example.speaking.model.entity.Person;
import com.example.speaking.repository.PersonRepository;
import com.example.speaking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public RegPersonResponse savePerson(RegPersonRequest regPersonRequest) {
        Person person = Person.builder()
                .email(regPersonRequest.getEmail())
                .password(regPersonRequest.getPassword())
                .firstName(regPersonRequest.getFirstName())
                .lastName(regPersonRequest.getLastName())
                .number(regPersonRequest.getNumber())
                .age(regPersonRequest.getAge())
                .build();
        personRepository.save(person);
        return RegPersonResponse.builder()
                .personId(person.getPersonId())
                .email(person.getEmail())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .number(person.getNumber())
                .age(person.getAge())
                .build();

    }
}


