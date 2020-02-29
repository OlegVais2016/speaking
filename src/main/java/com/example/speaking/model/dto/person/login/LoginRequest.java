package com.example.speaking.model.dto.person.login;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class LoginRequest {

    private String email;
    private String password;
}
