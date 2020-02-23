package com.example.speaking.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Document(collection = "persons")
public class Person {

    @Id
    private String personId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String number;
    private Integer age;

}
