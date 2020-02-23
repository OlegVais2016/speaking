package com.example.speaking.model.dto.reg;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class RegPersonResponse {

    private String personId;
    private String email;
    private String firstName;
    private String lastName;
    private String number;
    private Integer age;
}
