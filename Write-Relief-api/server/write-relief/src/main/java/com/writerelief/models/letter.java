package com.writerelief.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// This annotation identifies it as a document stored in MongoDB it represents a
@Document // document in your MongoDB database.
public class Letter {

    @Id // This annotation identifies the field as the primary key of the document.
    private String id;

    private String content; // Example field

    // Constructors, getters, and setters

    public Letter() {
    }

    public Letter(String content) {
        this.content = content;
    }

    // Getters and setters for all fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}