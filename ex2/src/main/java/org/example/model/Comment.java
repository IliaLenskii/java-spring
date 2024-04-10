package org.example.model;

public class Comment {

    private String author;

    private String text;

    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
