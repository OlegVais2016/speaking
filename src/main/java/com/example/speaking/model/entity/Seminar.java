package com.example.speaking.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Document(collection = "seminars")
public class Seminar {

    @Id
    private String semId;
    private Person arranger;
    private SeminarStatus eventStatus;
    private SeminarType eventType;
    private String title;
    private LocalDateTime date;
    private String city;
    private String street;
    private Integer entranceFee;
    private List<Person> participants;
}
