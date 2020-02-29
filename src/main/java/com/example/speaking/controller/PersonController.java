package com.example.speaking.controller;


import com.example.speaking.model.dto.person.login.LoginRequest;
import com.example.speaking.model.dto.person.login.LoginResponse;
import com.example.speaking.model.dto.person.register.RegisterRequest;
import com.example.speaking.model.dto.person.register.RegisterResponse;
import com.example.speaking.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/persons/create")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest){
        return personService.savePerson(registerRequest);
    }

    @PostMapping("/persons/login")
    public LoginResponse login (@RequestBody LoginRequest loginRequest){
        return personService.login(loginRequest);
    }
}

