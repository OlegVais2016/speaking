package com.example.speaking.service;

import com.example.speaking.model.dto.person.login.LoginRequest;
import com.example.speaking.model.dto.person.login.LoginResponse;
import com.example.speaking.model.dto.person.register.RegisterRequest;
import com.example.speaking.model.dto.person.register.RegisterResponse;

public interface PersonService {

    RegisterResponse savePerson(RegisterRequest registerRequest);
    LoginResponse login(LoginRequest loginRequest);
}
