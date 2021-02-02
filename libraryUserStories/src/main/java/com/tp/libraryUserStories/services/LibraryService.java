package com.tp.libraryUserStories.services;

import com.tp.libraryUserStories.exceptions.*;
import com.tp.libraryUserStories.models.Book;
import com.tp.libraryUserStories.persistence.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
        if(title == null || title.equals("")){
            throw new InvalidTitleException("Tried to add Book by null title");
        }

        if(publicationYear == null){
            throw new InvalidPublicationYearException("Tried to add Book by null publication year");

        }

        if(authors == null){
            throw new InvalidAuthorsException("Tried to add Book by null author");
        }

        if(publicationYear == 0){
            throw new InvalidPublicationYearException("Year have to be greater than zero");
        }

        int newYear = LocalDate.now().getYear();

        if(publicationYear > newYear){
            throw new InvalidPublicationYearException("The year can not be more than recent year");
        }

        if(authors.size() == 0){
            throw new InvalidAuthorsException("Each book should have one author");
        }
        for(String str: authors){
            if(str == null || str == ""){
                throw new InvalidAuthorsException("Tried to add Book by null author");
            }
        }
        int id = libraryDao.addBooks(title, authors, publicationYear);
        return libraryDao.getAllBookById(id);

    }

    public void deleteBooks(Integer bookId) throws InvalidBookIdException {
        libraryDao.deleteBooks(bookId);
    }

    public List<Book> getBooksByTitle(String title) throws InvalidTitleException {
        if(title == null){
            throw new InvalidTitleException("You can not get a book by null title");
        }
        return libraryDao.getBooksByTitle(title);
    }

    public List<Book> getBooksByAuthor(String author) throws InvalidAuthorsException {
        if(author == null){
            throw new InvalidAuthorsException("You can not get a book by null author");
        }
       return libraryDao.getBooksByAuthors(author);
    }

    public List<Book> getBooksByYear(Integer year) throws InvalidPublicationYearException {
        if(year == null){
            throw new InvalidPublicationYearException("You can not get a book by null year");
        }
        return libraryDao.getBooksByYear(year);
    }


    public Book updateBookByTitle(Integer id, String title) throws InvalidTitleException, InvalidBookIdException {
        if(title == null || title == ""){
            throw new InvalidTitleException("Title of the Book can not be null or empty");
        }

        Book newBook = getAllBookById(id);
        if(newBook == null ){
            throw new InvalidBookIdException("Book with id " + id + "is not found.");
        }

        newBook.setTitle(title);
        libraryDao.updateBook(newBook);
        return libraryDao.getAllBookById(id);
    }

    public Book updateBookByAuthor(Integer id, List<String> authors) throws InvalidAuthorsException, InvalidBookIdException {
        if(authors == null || authors.size() == 0){
            throw new InvalidAuthorsException("Book must have one author at least and can not be null");
        }
        for(String newAuthor: authors){
            if(newAuthor == null || newAuthor == ""){
                throw new InvalidAuthorsException("Authors can not be null or empty.");
            }
        }
        Book newBook = getAllBookById(id);
        if(newBook == null ){
            throw new InvalidBookIdException("Book with id " + id + "is not found.");
        }

        newBook.setAuthors(authors);
        libraryDao.updateBook(newBook);
        return libraryDao.getAllBookById(id);


    }

    public Book updateBookByPublicationYear(Integer id, Integer publicationYear) throws InvalidPublicationYearException, InvalidBookIdException{
        if(publicationYear == null){
            throw new InvalidPublicationYearException("Publication year can not be null.");

        }
        if(publicationYear == 0){
            throw new InvalidPublicationYearException("Year have to be greater than zero");
        }

        int newYear = LocalDate.now().getYear();

        if(publicationYear > newYear){
            throw new InvalidPublicationYearException("The year can not be more than recent year");
        }

        Book newBook = getAllBookById(id);
        if(newBook == null ){
            throw new InvalidBookIdException("Book with id " + id + "is not found.");
        }

        newBook.setPublicationYear(publicationYear);
        libraryDao.updateBook(newBook);
        return libraryDao.getAllBookById(id);

    }
}
