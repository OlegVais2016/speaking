package com.example.speaking.service;

import com.example.speaking.model.dto.person.login.LoginRequest;
import com.example.speaking.model.dto.person.login.LoginResponse;
import com.example.speaking.model.dto.person.register.RegisterRequest;
import com.example.speaking.model.dto.person.register.RegisterResponse;
import com.example.speaking.model.dto.person.update.UpdateRequest;
import com.example.speaking.model.dto.person.update.UpdateResponse;
import com.example.speaking.model.entity.Person;
import com.example.speaking.model.entity.PersonSession;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface PersonService {

    RegisterResponse savePerson(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest, HttpServletResponse response);
    void logout(String sessionId);
    RegisterResponse findById(String personId);
    RegisterResponse getByName(String firstName);
    UpdateResponse updateAccount(UpdateRequest updateRequest, Person person);
    List<UpdateResponse> getPersonsList();
    void deleteById(String personId);
}
