package com.tp.libraryUserStories.persistence;

import com.tp.libraryUserStories.exceptions.InvalidBookIdException;
import com.tp.libraryUserStories.exceptions.NullArgumentException;
import com.tp.libraryUserStories.models.Book;

import java.util.List;

public interface LibraryDao {

    int addBooks(String title, List<String> authors, Integer year) throws NullArgumentException;
    List<Book> getAllBooks();
    Book getAllBookById(Integer id);
    void deleteBooks(Integer bookId) throws InvalidBookIdException;
}
