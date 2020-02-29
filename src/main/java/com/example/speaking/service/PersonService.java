package com.example.speaking.service;

import com.example.speaking.model.dto.reg.RegPersonRequest;
import com.example.speaking.model.dto.reg.RegPersonResponse;

public interface PersonService {

    RegPersonResponse savePerson(RegPersonRequest regPersonRequest);
}
