package com.example.speaking.controller;


import com.example.speaking.model.dto.person.login.LoginRequest;
import com.example.speaking.model.dto.person.login.LoginResponse;
import com.example.speaking.model.dto.person.register.RegisterRequest;
import com.example.speaking.model.dto.person.register.RegisterResponse;
import com.example.speaking.model.dto.person.update.UpdateRequest;
import com.example.speaking.model.dto.person.update.UpdateResponse;
import com.example.speaking.model.entity.Person;
import com.example.speaking.service.PersonService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest){
        return personService.savePerson(registerRequest);
    }

    @PostMapping("/login")
    public LoginResponse login (@RequestBody LoginRequest loginRequest){
        return personService.login(loginRequest);
    }

    @PutMapping("/logout")
    public void logout(@RequestHeader(value = "Authorization") String token) {
        personService.logout(token);
    }

    @PostMapping("/update")
    public UpdateResponse updateAccount(@RequestBody UpdateRequest updateRequest,
                                        @AuthenticationPrincipal Person person){
        return personService.updateAccount(updateRequest,person);
    }

    @GetMapping("/persons")
    public List<UpdateResponse> getPersonsList(){
        return personService.getPersonsList();
    }

    @DeleteMapping("/delete/{personId}")
    public void delete(@PathVariable String personId){
        personService.deleteById(personId);
    }
}

