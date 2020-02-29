package com.example.speaking.repository;

import com.example.speaking.model.entity.PersonSession;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonSessionRepository extends MongoRepository<PersonSession,String> {
    PersonSession findBySessionIdAndIsValidTrue(String sessionId);
}
