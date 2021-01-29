package com.tp.libraryUserStories.persistence;

import com.tp.libraryUserStories.exceptions.*;
import com.tp.libraryUserStories.models.Book;

import java.util.List;

public interface LibraryDao {

    int addBooks(String title, List<String> authors, Integer year)
            throws InvalidTitleException,
            InvalidAuthorsException,
            InvalidPublicationYearException;
    List<Book> getAllBooks();
    Book getAllBookById(Integer id);
    void deleteBooks(Integer bookId) throws InvalidBookIdException;
    List<Book> getBooksByTitle(String title) throws InvalidTitleException;
    List<Book> getBooksByAuthors(String author) throws InvalidAuthorsException;
    List<Book> getBooksByYear(Integer year) throws InvalidPublicationYearException;
    Book editBook(Integer bookId, Book newBook) throws InvalidTitleException, InvalidAuthorsException, InvalidPublicationYearException;
    Book thatBook(Book book) throws InvalidBookIdException, InvalidAuthorsException;
}
