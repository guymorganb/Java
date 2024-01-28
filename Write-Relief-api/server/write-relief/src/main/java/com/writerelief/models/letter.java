package com.writerelief.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// This annotation identifies it as a document stored in MongoDB it represents a
@Document // document in your MongoDB database.
public class Letter {
// MongoDB will automatically generate a unique ID for new documents if the ID field is null.
    @Id // This annotation identifies the field as the primary key of the document.
    private String id;

    private String content;
    // add a reference to the userID who wrote the letter
    private String userID;
    
    // Constructors, getters, and setters

    public Letter() {
    }

 // Constructor with parameters for content and userID.
 public Letter(String content, String userID) {
    this.content = content;
    this.userID = userID;
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

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

}