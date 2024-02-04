package com.writerelief.writerelief.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.writerelief.writerelief.models.Letter;

import reactor.core.publisher.Flux;

/**
 * For the reactive repository, use ReactiveMongoRepository.
 * It returns Mono and Flux types from Project Reactor to work with the
 * asynchronous data flow.
 */
@Repository
public interface LetterRepository extends ReactiveMongoRepository<Letter, String> {
    // Extending ReactiveMongoRepository gives access to standard MongoDB operations
    // for the Letter entity, with String as the type of the entity's ID.

    // Custom query methods can be defined here. These methods are implemented by
    // Spring Data
    // and used in the service and controller layers.

    // ReactiveMongoRepository provides standard CRUD methods, including deleteById,
    // so we don't need to define it here.

    // findByUserId is a custom query method, not provided directly by
    // ReactiveMongoRepository.
    // This method will be used to find all letters associated with a particular
    // user ID.
    // The method returns a Flux<Letter>, representing a reactive stream of Letter
    // objects.

    @Query("{ 'userID': ?0 }")
    Flux<Letter> findByUserId(String userID);

    // OR use @Query annotation for more flexibility
    // @Query annotation defines a custom query where the tags field must contain
    // the value provided by the tag parameter of the findLettersByTag method. When
    // this method is called, Spring Data MongoDB executes the provided query
    // against the MongoDB database.
    @Query("{ 'tags': ?0 }")
    Flux<Letter> findLettersByTag(String tag);

    // Derive query method from method name
    Flux<Letter> findByTagsContaining(String tag);
}