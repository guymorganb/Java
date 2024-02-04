// implement a class that is for displaying the blog and managing blog data
class BlogLetter{
    // Private fields to store blog post properties
    #title; // Title of the blog post
    #body; // Main content/body of the blog post
    #date; // Publication date of the blog post
    #author; // Author of the blog post
    #likes; // Number of likes the blog post has received
    #bookmarked; // Set of user IDs who have bookmarked the blog
    #trending; // Numerical ranking or priority of the blog post
    #tags; // Array of tags/keywords associated with the blog post
    #category; // Category or section under which the blog post falls
    #bookmarksCount; // (Assuming intention to track total bookmarks across all users)
    #readTime; // Estimated time required to read the blog post
    #lastUpdated; // Timestamp of the last update to the blog post
    #visibility; // Visibility status of the post ('public', 'private', etc.)
    #featuredImageUrl; // URL of the featured image for the blog post
    #summary; // A short summary or excerpt of the blog post
    #seoDescription; // SEO meta description for the blog post
    #slug; // URL-friendly slug derived from the title
    constructor(title, body, date, author, category) {
        this.#title = title;
        this.#body = body;
        this.#date = date;
        this.#author = author;
        this.#likes = 0;
        this.#bookmarked = new Set(); // Stores user IDs of users who bookmarked
        this.#trending = 0; // Assuming trending is numeric, initializing with 0 or another sensible default
        this.#tags = [];
        this.#category = category;
        this.#bookmarksCount = 0; // numeric count, initializing with 0
        this.#readTime = null; // calculated based on body length or set explicitly
        this.#lastUpdated = date; // Initially the same as creation date
        this.#visibility = 'public'; // Default visibility
        this.#featuredImageUrl = '';
        this.#summary = '';
        this.#seoDescription = '';
        this.#slug = this.generateSlug(title); // Generate a slug based on the title
    }
    // Getters and setters for each field to encapsulate and manage access
    get title(){
        return this.#title;
    }

    get body(){
        return this.#body;
    }

    get date(){
        return this.#date;
    }

    get author(){
        return this.#author;
    }

    set title(title){
        this.#title = title;
    }

    set body(body){
        this.#body = body;
    }
    
    set date(date){
        this.#date = date;
    }

    set author(author){
        this.#author = author;
    }
    // Method to increment the number of likes
    addLikes(num){
        this.#likes += num;
    }

    get bookmarksCount(){
        return this.#bookmarksCount;
    }

    set category(category){
        this.#category = category;
    }

    get category(){
        return this.#category;
    }

    get likes(){
        return this.#likes;
    }
    // Method to add a bookmark for a user
    bookmarkByUser(userId) {
        this.#bookmarked.add(userId);
    }
    // Method to remove a bookmark for a user
    removeBookmarkByUser(userId) {
        this.#bookmarked.delete(userId);
    }
    // check if bookmarked by userID
    getBookmarkedByUser(userId) {
        return this.#bookmarked.has(userId);
    }
    // sets the overall ranking of the blog
    set trending(rank){
        this.#trending = rank;
    }
    // returns the overall ranking of the blog
    get ranking(){
        return this.#trending;
    }
    // Method to add multiple tags to the post
    setTags(newTags){
        this.#tags = [...this.#tags, ...newTags];
    }
    // Method to add a single tag to the post
    addTag(tag) {
        this.#tags.push(tag);
    }

    get tags(){
        return this.#tags;
    }
    // Method to filter the post's tags by a specific tag
    fiterTags(filterTag){
        return this.#tags.filter(tag => tag === filterTag);
    }

    get readTime() {
        return this.#readTime;
    }

    set readTime(time) {
        this.#readTime = time;
    }

    get lastUpdated() {
        return this.#lastUpdated;
    }

    set lastUpdated(date) {
        this.#lastUpdated = date;
    }

    get visibility() {
        return this.#visibility;
    }

    set visibility(status) {
        this.#visibility = status;
    }

    get featuredImageUrl() {
        return this.#featuredImageUrl;
    }

    set featuredImageUrl(url) {
        this.#featuredImageUrl = url;
    }

    get summary() {
        return this.#summary;
    }

    set summary(summary) {
        this.#summary = summary;
    }

    get seoDescription() {
        return this.#seoDescription;
    }

    set seoDescription(description) {
        this.#seoDescription = description;
    }

    get slug() {
        return this.#slug;
    }

    // Method to generate a URL-friendly slug from the post title
    generateSlug(title) {
        // Convert title to lowercase and replace non-alphanumeric characters with hyphens
        return title.toLowerCase().replace(/[^a-z0-9]+/g, '-').replace(/(^-|-$)/g, '');
    }
}