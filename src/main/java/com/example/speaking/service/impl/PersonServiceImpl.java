package com.example.speaking.service.impl;

import com.example.speaking.model.dto.person.login.LoginRequest;
import com.example.speaking.model.dto.person.login.LoginResponse;
import com.example.speaking.model.dto.person.register.RegisterRequest;
import com.example.speaking.model.dto.person.register.RegisterResponse;
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
    public RegisterResponse savePerson(RegisterRequest registerRequest) {
        Person person = Person.builder()
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .number(registerRequest.getNumber())
                .age(registerRequest.getAge())
                .build();
        personRepository.save(person);
        return RegisterResponse.builder()
                .personId(person.getPersonId())
                .email(person.getEmail())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .number(person.getNumber())
                .age(person.getAge())
                .build();

    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }
}


