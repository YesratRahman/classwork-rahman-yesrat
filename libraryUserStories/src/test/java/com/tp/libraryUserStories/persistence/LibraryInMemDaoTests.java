package com.tp.libraryUserStories.persistence;

import com.tp.libraryUserStories.exceptions.InvalidAuthorsException;
import com.tp.libraryUserStories.exceptions.InvalidBookIdException;
import com.tp.libraryUserStories.exceptions.InvalidPublicationYearException;
import com.tp.libraryUserStories.exceptions.InvalidTitleException;
import com.tp.libraryUserStories.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibraryInMemDaoTests {

    @Autowired
    LibraryDao toTest;

    @BeforeEach
    public void setUp() throws InvalidBookIdException, InvalidTitleException, InvalidAuthorsException, InvalidPublicationYearException {
        List<Book> allBooks = toTest.getAllBooks();

        for (Book toRemove : allBooks) {
            toTest.deleteBooks(toRemove.getBookId());
        }
       toTest.addBooks("The Example", Arrays.asList("Tom Taylor"), 2005);
    }

    @Test
    public void testAddBooksGoldenPath() throws InvalidTitleException, InvalidPublicationYearException, InvalidAuthorsException {


        Book book = toTest.getAllBookById(1);

            assertEquals("The Example", book.getTitle());
            assertEquals(1, book.getAuthors().size());
            assertEquals("Tom Taylor", book.getAuthors().get(0));
            assertEquals(2005, book.getPublicationYear());

            int id = toTest.addBooks("book2", Arrays.asList("author1", "author2"), 2004);
            Book newBook = toTest.getAllBookById(2);

            assertEquals(2, newBook.getBookId());
            assertEquals("book2", newBook.getTitle());
            assertEquals(2004, newBook.getPublicationYear());
            assertEquals(2, newBook.getAuthors().size());
            assertEquals("author1", newBook.getAuthors().get(0));
            assertEquals("author2", newBook.getAuthors().get(1));

    }

//    @Test
//    public void testNullBookObject() {
//        //Book newBook = null;
//    throw new UnsupportedOperationException();
//    }

    @Test
    public void testAddBooksByNullTitle() {
        try {
            List<Book> book = toTest.getBooksByTitle(null);
            fail();
        } catch (InvalidTitleException e) {
        }
    }


    @Test
    public void testAddBooksByNullAuthor() {
        try {
            List<Book> book = toTest.getBooksByAuthors(null);
            fail();
        } catch (InvalidAuthorsException e) {
        }
    }


    @Test
    public void testAddBookByNullYear() {
        try {
            int bookId = toTest.addBooks("title", Arrays.asList("author"), null);
            fail();
        } catch (InvalidTitleException | InvalidAuthorsException e) {
            fail();
        } catch (InvalidPublicationYearException e) {

        }
    }




    @Test
    public void testGetAllBooksGoldenPath() {
        List<Book> toCopy = toTest.getAllBooks();
        assertEquals(1, toCopy.size());
        assertEquals("The Example", toCopy.get(0).getTitle());
    }

    @Test
    public void testGetBookByInvalidId() {
        Book book = toTest.getAllBookById(-1);
        assertEquals(null, book);
    }

    @Test
    public void testDeleteBookByInvalidId() {
        try{
            toTest.deleteBooks(1);
            toTest.deleteBooks(1);
            fail();
        }catch (InvalidBookIdException e){

        }
    }

    @Test
    public void testDeleteBookById() {
    try {
        toTest.deleteBooks(1);
        assertEquals(0, toTest.getAllBooks().size());
    } catch(
    InvalidBookIdException e) {
        fail();
    }
}

}






