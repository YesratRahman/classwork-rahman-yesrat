package com.tp.libraryUserStories.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private Integer bookId;
    private String title;
    private List<String> authors;
    private Integer publicationYear;

    public Book(Integer bookId, String title, List<String> authors, Integer publicationYear){
        this.bookId = bookId;
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
    }

    //copy constructor
    public Book(Book that){
        this.bookId = that.bookId;
        this.title = that.title;
        this.publicationYear = that.publicationYear;
        this.authors = new ArrayList<>();
        for(String toCopy : that.authors){
            this.authors.add(toCopy);
        }
    }

    public Book() {

    }


    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

}
