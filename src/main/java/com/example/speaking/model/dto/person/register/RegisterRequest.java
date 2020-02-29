package com.example.speaking.model.dto.person.register;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RegisterRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String number;
    private Integer age;
}
