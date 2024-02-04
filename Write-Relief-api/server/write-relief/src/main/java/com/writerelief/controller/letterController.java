package com.writerelief.controller;

import org.springframework.web.bind.annotation.*;
import com.writerelief.models.Letter;
import com.writerelief.service.LetterService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Client
 * │
 * │ (HTTP Request)
 * ▼
 * Controller
 * │
 * │ (Method call with params)
 * ▼
 * Service
 * │
 * │ (Business logic / Method call)
 * ▼
 * Repository
 * │
 * │ (Database operation)
 * ▼
 * Model / Database
 * │
 * │ (Results / Data)
 * ▲
 * Repository
 * │
 * │ (Processed data / Entities)
 * ▲
 * Service
 * │
 * │ (Optional additional processing)
 * ▲
 * Controller
 * │
 * │ (HTTP Response)
 * ▲
 * Client
 */
@RestController // Annotation to mark this class as a REST Controller in your Spring application
@RequestMapping("/api/letters") // Specifies URL for the methods in this controller will start with "/letters"
public class LetterController {

  @Autowired // Automatically injects an instance of LetterService into this controller
  private LetterService letterService;

  // Constructor for LetterController, useful for dependency injection
  public LetterController(LetterService letterService) {
    this.letterService = letterService;
  }

  // Endpoint for creating a new letter. It handles POST requests to "/letters"
  @PostMapping
  public Mono<ResponseEntity<Letter>> createLetter(@RequestBody Mono<Letter> letterMono) {
    return letterService
        // Calls saveLetter method from letterService with the Mono<Letter> from the
        // request body
        .saveLetter(letterMono)
        // Maps the saved letter to a ResponseEntity with a status of CREATED (HTTP 201)
        .map(savedLetter -> ResponseEntity.status(HttpStatus.CREATED).body(savedLetter));
    // "arrow function looking thing" in your code is a lambda expression, which is
    // a feature introduced in Java 8. Lambda expressions provide a clear and
    // concise way to represent a method interface using an expression.
  }

  // Endpoint for retrieving all letters. It handles GET requests to "/letters"
  @GetMapping
  public Flux<Letter> getAllLetters() {
    // Calls getAllLetters method from letterService to fetch all letters
    return letterService.getAllLetters();
  }
  
  // endpoint for getting tags
  @GetMapping("/tag/{tag}")
  public Flux<Letter> getLettersByTag(@PathVariable String tag) {
      // Call the service method to fetch letters by tag
      return letterService.findLettersByTag(tag);
  }

  // Endpoint for deleting a letter by its ID. It handles DELETE requests to
  // "/letters/{id}"
  @DeleteMapping("/{id}")
  public void deleteLetter(@PathVariable String id) {
    // Calls deleteLetter method from letterService with the letter ID
    letterService.deleteLetter(id);
  }

  // Endpoint for retrieving all letters for a specific user. It handles GET
  // requests to "/letters/user/{userId}"
  @GetMapping("/user/{userId}")
  public Flux<Letter> getLettersByUserId(@PathVariable String userId) {
    // Calls findByUserId method from letterService to fetch letters belonging to a
    // specific user
    return letterService.findByUserId(userId);
  }
  // You can add more endpoints to handle different CRUD operations
}