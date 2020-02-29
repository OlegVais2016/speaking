package com.example.speaking.controller;

import com.example.speaking.model.dto.reg.RegPersonRequest;
import com.example.speaking.model.dto.reg.RegPersonResponse;
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
    public RegPersonResponse register(@RequestBody RegPersonRequest regPersonRequest){
        return personService.savePerson(regPersonRequest);
    }

}
