package com.writerelief.models;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// This annotation identifies it as a document stored in MongoDB it represents a
@Document // document in your MongoDB database.
public class Letter {
// MongoDB will automatically generate a unique ID for new documents if the ID field is null.
    @Id // This annotation identifies the field as the primary key of the document.
    private String id;
    private String title;
    private String content;
    private String userID; // Reference to the user who wrote the letter
    private String date; // Publication date
    private int likes; // Number of likes
    private Set<String> bookmarkedUsers; // Users who have bookmarked the blog
    private int trending; // Trending score or rank
    private List<String> tags; // Tags associated with the blog
    private String category; // Blog category
    private String readTime; // Estimated read time
    private String lastUpdated; // Timestamp for the last update
    private String visibility; // Visibility status ('public', 'private', etc.)
    private String featuredImageUrl; // URL for the featured image
    private String summary; // Short summary or excerpt
    private String seoDescription; // SEO meta description
    private String slug; // URL-friendly slug
    
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

    public void setTitle(String title) {
        this.title = title;  // set the title of the letter to the title parameter. 
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Set<String> getBookmarkedUsers() {
        return bookmarkedUsers;
    }

    public void setBookmarkedUsers(Set<String> bookmarkedUsers) {
        this.bookmarkedUsers = bookmarkedUsers;
    }

    public int getTrending() {
        return trending;
    }

    public void setTrending(int trending) {
        this.trending = trending;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }
    
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getFeaturedImageUrl() {
        return featuredImageUrl;
    }

    public void setFeaturedImageUrl(String featuredImageUrl) {
        this.featuredImageUrl = featuredImageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSeoDescription() {
        return seoDescription;
    }
    
    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getSlug() {
        return slug;
    }

    public void setDate(int date) {
        this.date = String.valueOf(date);
    }
    /**
     * Generates a URL-friendly slug from a string.
     * 
     * @param input The input string to convert into a slug.
     * @return A URL-friendly slug.
     */
    public String generateSlug(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        
        String slug = input.toLowerCase() // Convert to lower case
                .replaceAll("[^a-z0-9\\s]", "") // Replace all non-alphanumeric characters except spaces
                .replaceAll("\\s+", "-") // Replace one or more spaces with a single hyphen
                .replaceAll("^-+|-+$", ""); // Trim leading or trailing hyphens
        
        return slug;
    }
    
    public void setSlug(String slug) {
        this.slug = slug;
    }

}