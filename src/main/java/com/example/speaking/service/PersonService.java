package com.example.speaking.service;

import com.example.speaking.model.dto.person.login.LoginRequest;
import com.example.speaking.model.dto.person.login.LoginResponse;
import com.example.speaking.model.dto.person.register.RegisterRequest;
import com.example.speaking.model.dto.person.register.RegisterResponse;
import com.example.speaking.model.dto.person.update.UpdateRequest;
import com.example.speaking.model.dto.person.update.UpdateResponse;
import com.example.speaking.model.entity.Person;

import java.util.List;

public interface PersonService {

    RegisterResponse savePerson(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
    void logout(String token);
    UpdateResponse updateAccount(UpdateRequest updateRequest, Person person);
    List<UpdateResponse> getPersonsList();
}
