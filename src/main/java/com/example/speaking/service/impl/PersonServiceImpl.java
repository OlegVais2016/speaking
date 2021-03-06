package com.example.speaking.service.impl;

import com.example.speaking.exception.AuthenticationException;
import com.example.speaking.exception.PersonNotFoundException;
import com.example.speaking.model.dto.person.login.LoginRequest;
import com.example.speaking.model.dto.person.login.LoginResponse;
import com.example.speaking.model.dto.person.register.RegisterRequest;
import com.example.speaking.model.dto.person.register.RegisterResponse;
import com.example.speaking.model.dto.person.update.UpdateRequest;
import com.example.speaking.model.dto.person.update.UpdateResponse;
import com.example.speaking.model.entity.Person;
import com.example.speaking.model.entity.PersonSession;
import com.example.speaking.repository.PersonRepository;
import com.example.speaking.repository.PersonSessionRepository;
import com.example.speaking.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final PersonSessionRepository personSessionRepository;


    public PersonServiceImpl(PersonRepository personRepository, PersonSessionRepository personSessionRepository) {
        this.personRepository = personRepository;
        this.personSessionRepository = personSessionRepository;
    }

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
        log.info("New person created");
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
    public RegisterResponse login(LoginRequest loginRequest, HttpServletResponse response) {

        Person person = personRepository.findByEmailAndPassword
                (loginRequest.getEmail(), loginRequest.getPassword());
        if (person == null) {
            log.warn("Incorrect username or password. Incoming parameters are: {} - {}",
                    loginRequest.getEmail(), loginRequest.getPassword());
            throw new AuthenticationException("Username or password is incorrect");
        }
        PersonSession personSession =
                personSessionRepository.save(PersonSession.builder()
                        .sessionId(UUID.randomUUID().toString())
                        .person(person)
                        .isValid(true)
                .build());
        log.debug("User with name = {} logged in", person.getFirstName());
        response.setHeader("Authorization", personSession.getSessionId());
        log.info( "token: " + personSession.getSessionId());

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
    public void logout(String sessionId) {
        PersonSession personSession = personSessionRepository
                .findBySessionIdAndIsValidTrue(sessionId);
        if(personSession == null){
            throw new AuthenticationException("Email or password is incorrect");
        }
        personSession.setIsValid(false);
        personSessionRepository.save(personSession);

       log.debug("Session ID = {} invalidated", sessionId);
    }

    @Override
    public RegisterResponse findById(String personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(()-> new PersonNotFoundException(personId));

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
    public List<RegisterResponse> getByName(String firstName) {

        List<Person> persons = personRepository.findByName(firstName);

        return persons.stream()
                .map(this::transform2)
                .collect(Collectors.toList());
    }

    @Override
    public UpdateResponse updateAccount(UpdateRequest updateRequest, Person person) {

        person.setFirstName(updateRequest.getFirstName());
        person.setLastName(updateRequest.getLastName());
        person.setNumber(updateRequest.getNumber());
        person.setAge(updateRequest.getAge());
        personRepository.save(person);

        return UpdateResponse.builder()
                .personId(person.getPersonId())
                .email(person.getEmail())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .number(person.getNumber())
                .age(person.getAge())
                .build();
    }

    @Override
    public List<UpdateResponse> getPersonsList() {
        return personRepository.findAll().stream()
                .map(this::transform)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteById(String personId) {
        personRepository.deleteById(personId);
    }

    private UpdateResponse transform(Person person){
        return UpdateResponse.builder()
                .personId(person.getPersonId())
                .email(person.getEmail())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .age(person.getAge())
                .number(person.getNumber())
                .build();
    }
    private RegisterResponse transform2(Person person){
        return RegisterResponse.builder()
                .personId(person.getPersonId())
                .email(person.getEmail())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .age(person.getAge())
                .number(person.getNumber())
                .build();
    }
}

