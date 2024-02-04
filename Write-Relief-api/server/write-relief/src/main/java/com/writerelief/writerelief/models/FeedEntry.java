package com.writerelief.writerelief.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document // document in your MongoDB database.
public class FeedEntry {

    // feed entry is the list of sent letters basically
    // each tim a user sends their letter, it goes in
    // as a feed entry into the database

    @Id // This annotation identifies the field as the primary key of the document.
    private String id;

    private String title;

    private String content;

    private String userID;

    // data memeber fo comments
    private String comments;

    // likes
    private String likes;

    // constructor method
    public FeedEntry(String cont, String id) {
        this.content = cont;
        this.userID = id;
    }

    public void setTitle(String title) {
        this.title = title; // set the title of the letter to the title parameter.
    }

    public String getTitle() {
        return title;
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

    public void setComments(String comment) {
        this.comments = comment;
    }

    public String getComments() {
        return this.comments;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getLikes() {
        return this.likes; // set the title of the letter to the title parameter.
    }
}
