package com.writerelief.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.writerelief.models.Letter;

@Repository
public interface LetterRepository extends MongoRepository<Letter, String> {
    // Custom query methods can be defined here
}