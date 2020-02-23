package com.example.speaking.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Document(collection = "sessions")
public class PersonSession {

    @Id
    private String id;
    private String sessionId;
    private Boolean isValid;
    private Person person;
}

