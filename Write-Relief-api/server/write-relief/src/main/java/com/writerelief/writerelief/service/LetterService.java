package com.writerelief.writerelief.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.lang.NonNull;

import com.writerelief.writerelief.models.Letter;
import com.writerelief.writerelief.repository.LetterRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The service class, will be returning reactive types (Mono and Flux),
 * which are at the heart of the reactive programming model provided by Project
 * Reactor.
 * A Mono represents a stream of 0 to 1 elements, and Flux represents a stream
 * of 0 to N elements.
 */
// Marks this class as a Spring service, a special type of component for holding
// business logic
@Service
public class LetterService {

    // Automatically injects an instance of LetterRepository into this service
    @Autowired // annotation is used in Spring to automatically inject the dependencies
    private LetterRepository letterRepository;

    // Constructor for LetterService, useful for dependency injection
    public LetterService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    // Method for saving a letter. It takes a Mono of Letter, flattens it, and saves
    // it to the repository.
    // Returns a Mono that emits the saved Letter object.
    public Mono<Letter> saveLetter(Mono<Letter> letterMono) {
        // flatMap is used to transform the Mono<Letter> to another Mono (Mono from the
        // save operation)
        return letterMono.flatMap(letterRepository::save);
    }

    // Method to retrieve all letters. It returns a Flux of Letter.
    // Flux represents a reactive sequence of multiple items.
    public Flux<Letter> getAllLetters() {
        // findAll method of the repository is used, which returns a Flux of Letter
        return letterRepository.findAll();
    }

    // Method to delete a letter by its ID. This method does not return anything.
    public void deleteLetter(@NonNull String id) {
        // deleteById method of the repository is called with the provided letter ID
        letterRepository.deleteById(id);
    }

    // Method to find letters by a user's ID. Returns a Flux of Letter.
    // Flux represents a reactive sequence of multiple items.

    public Flux<Letter> findByUserId(String id) {
        // findByUserId method of the repository is used, which returns a Flux of Letter
        return letterRepository.findByUserId(id);
    }

    public Flux<Letter> findLettersByTag(String tag) {
        // Choose either method based on your preference or requirements
        return letterRepository.findByTagsContaining(tag);
        // Or for custom @Query
        // return letterRepository.findLettersByTag(tag);
    }
    // Additional service methods can be added as needed
}
