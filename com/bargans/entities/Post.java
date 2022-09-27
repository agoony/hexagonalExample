package com.bargans.entities;

import java.time.LocalDateTime;
import java.util.Date;

import static java.time.LocalTime.now;

public class Post implements Comparable<Post> {

    private String post;
    private LocalDateTime dateTime;
    private String author;

    public Post(String post, String author) {
        this.post = post;
        this.dateTime = LocalDateTime.now();
        this.author = author;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDateTime getTime() {
        return dateTime;
    }

    public void setTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    @Override
    public int compareTo(Post o) {
        Post f = (Post) o;
        return this.dateTime.isAfter(f.dateTime)?1:0;

    }
}
