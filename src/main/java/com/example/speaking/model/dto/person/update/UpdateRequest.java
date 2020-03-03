package com.example.speaking.model.dto.person.update;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UpdateRequest {

    private String firstName;
    private String lastName;
    private String number;
    private Integer age;
}
