package com.tp.libraryUserStories.services;

import com.tp.libraryUserStories.exceptions.*;
import com.tp.libraryUserStories.models.Book;
import com.tp.libraryUserStories.persistence.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryService {

    @Autowired
    LibraryDao libraryDao;

    public Book getAllBooks(String title, List<String > authors, Integer year) throws InvalidTitleException, InvalidPublicationYearException, InvalidAuthorsException {
        int id = libraryDao.addBooks(title, authors, year);

        return libraryDao.getAllBookById(id);
    }

    public List<Book> getAllBooks(){
        return libraryDao.getAllBooks();
    }

    public Book getAllBookById(Integer id) throws InvalidBookIdException{
        if(id == null) {
            throw new InvalidBookIdException("Book ID cannot be null");
        }

        return libraryDao.getAllBookById(id);
    }

    public Book addBooks(String title, List<String> authors, Integer publicationYear)
            throws InvalidPublicationYearException,
            InvalidAuthorsException,
            InvalidTitleException {

        int id = libraryDao.addBooks(title, authors, publicationYear);
        return libraryDao.getAllBookById(id);

    }

    public void deleteBook(Integer bookId) throws InvalidBookIdException {
        libraryDao.deleteBooks(bookId);
    }

    public List<Book> getBooksByTitle(String title) throws InvalidTitleException {
        return libraryDao.getBooksByTitle(title);
    }

    public List<Book> getBooksByAuthor(String author) throws InvalidAuthorsException {
       return libraryDao.getBooksByAuthors(author);
    }

    public List<Book> getBooksByYear(Integer year) throws InvalidPublicationYearException {
        return libraryDao.getBooksByYear(year);
    }
}
