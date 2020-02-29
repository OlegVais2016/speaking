package com.example.speaking.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends BaseException {

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }

    public AuthenticationException(String message) {
        super(message);
    }
}
