package com.writerelief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.writerelief.models.Letter;
import com.writerelief.repository.LetterRepository;

import java.util.List;

@Service
public class LetterService {

    private final LetterRepository letterRepository;

    @Autowired
    public LetterService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    public Letter saveLetter(Letter letter) {
        return letterRepository.save(letter);
    }

    public List<Letter> getAllLetters() {
        return letterRepository.findAll();
    }

    // Additional service methods can be added as needed
}
