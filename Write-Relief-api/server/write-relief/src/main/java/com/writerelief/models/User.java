package com.writerelief.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Document
public class User {
    @Id // This annotation identifies the field as the primary key of the document.
    private String id;

    private String firstName;

    private String lastName;

    private String password;

    private String email;
    // keep a list of the letters written by the user
    private List<String> letterIds;

    public User() {
    }
    public User( String fN, String lN, String p, String e) {
        this.firstName = fN;
        this.lastName = lN;
        this.password = p;
        this.email = e;
    }
    // Getters and setters for all fields
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    // return a list of letters associated with the user
    public List<String> getLetterIds() {
        return letterIds;
    }
    // Verify Password
    public boolean checkPassword(String plainPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(plainPassword, this.password);
    }
    // Hash Password
    public void setPassword(String plainPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(plainPassword);
    }
    // return a JSON object of the the USER object
    public String getUser() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
    // update 
    public void updateUser ( String fN, String lN, String p, String e) {
        if(fN != null){
            this.firstName = fN;
        }if(lN != null){
            this.lastName = lN;
        }if(p != null){
            this.password = p;
        }if(e != null){
            this.email = e;
        }
    }
}