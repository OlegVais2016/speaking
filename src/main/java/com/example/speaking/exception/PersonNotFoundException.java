package com.example.speaking.exception;

import org.springframework.http.HttpStatus;

public class PersonNotFoundException extends BaseException {
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
    public PersonNotFoundException (String personId){
        super(String.format("Person with ID [%s] not found", personId));
    }
}
