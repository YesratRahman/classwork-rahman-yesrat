package com.tp.libraryUserStories.services;


import com.tp.libraryUserStories.exceptions.InvalidAuthorsException;
import com.tp.libraryUserStories.exceptions.InvalidBookIdException;
import com.tp.libraryUserStories.exceptions.InvalidPublicationYearException;
import com.tp.libraryUserStories.exceptions.InvalidTitleException;
import com.tp.libraryUserStories.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryServiceTest {

    @Autowired
    LibraryService toTest;

    @BeforeEach
    public void setup() {
        List<Book> allBooks = toTest.libraryDao.getAllBooks();

        try {
            for (Book toRemove : allBooks) {
                toTest.libraryDao.deleteBooks(toRemove.getBookId());
            }

            toTest.addBooks("The Example", Arrays.asList("author"), 2005);
        } catch (InvalidBookIdException | InvalidTitleException | InvalidAuthorsException | InvalidPublicationYearException ex) {
            fail();
        }
    }

    @Test
    public void testAddBooksGoldenPath() {
        try {
            int id = toTest.addBooks("new Book", Arrays.asList("author1", "author2"), 2010).getBookId();
            assertEquals(2, id);
            int nextId = toTest.addBooks("The Prince", Arrays.asList("author3"), 2004).getBookId();
            assertEquals(3, nextId);
            Book validation = toTest.getAllBookById(3);
            assertEquals("The Prince", validation.getTitle());
            List<String> validationAuthors = validation.getAuthors();
            assertEquals(1, validationAuthors.size());
            assertEquals("author3", validationAuthors.get(0));
            assertEquals(2004, validation.getPublicationYear());
            assertEquals(3, validation.getBookId());
        } catch (InvalidAuthorsException | InvalidTitleException | InvalidPublicationYearException | InvalidBookIdException ex) {
            fail();
        }
    }

    @Test
    public void testAddBooksNullTitle() {
        try {
            Book book = toTest.addBooks(null, Arrays.asList("The prince", "author"), 2004);
            fail();
        } catch (InvalidAuthorsException | InvalidPublicationYearException ex) {
            fail();
        } catch (InvalidTitleException ex) {
            try {
                Book book = toTest.addBooks("", Arrays.asList("author1", "author2"), 2004);
                fail();
            } catch (InvalidAuthorsException | InvalidPublicationYearException ex2) {
                fail();
            } catch (InvalidTitleException ex2) {

            }
        }
    }
    @Test
    public void testAddBookEmptyAuthors() {
        try {
            Book book = toTest.addBooks("The Prince", Arrays.asList(), 2010);
            fail();
        } catch (InvalidTitleException | InvalidPublicationYearException ex) {
            fail();
        } catch (InvalidAuthorsException ex) {

        }
    }
    @Test
    public void testAddBookNullAuthor() {
        try {
            Book book = toTest.addBooks("The title", null, 2010);
            fail();
        } catch (InvalidTitleException | InvalidPublicationYearException ex) {
            fail();
        } catch (InvalidAuthorsException ex) {

        }
    }

    @Test
    public void testAddAuthorListWithNullAuthors() {
        try {
            Book book = toTest.addBooks("One title", Arrays.asList("two title", null, "author"), 2010);
            fail();
        } catch (InvalidTitleException | InvalidPublicationYearException ex) {
            fail();
        } catch (InvalidAuthorsException ex) {
            try {
                Book book = toTest.addBooks("The Example", Arrays.asList("author1", "", "author2"), 2002);
                fail();
            } catch (InvalidTitleException | InvalidPublicationYearException ex2) {
                fail();
            } catch (InvalidAuthorsException ex2) {

            }
        }
    }

    @Test
    public void testAddBookNullYear() {
        try {
            Book book = toTest.addBooks("Example", Arrays.asList("author1", "author2"), null);
            fail();
        } catch (InvalidTitleException | InvalidAuthorsException ex) {
            fail();
        } catch (InvalidPublicationYearException ex) {

        }
    }

    @Test
    public void testAddBookFutureYear() {
        try {
            Book book = toTest.addBooks("The examples", Arrays.asList("author1", "author2"), 2030);
            fail();
        } catch (InvalidTitleException | InvalidAuthorsException ex) {
            fail();
        } catch (InvalidPublicationYearException ex) {

        }
    }

    @Test
    public void testGetAllBooksGoldenPath() {
        List<Book> copy = toTest.getAllBooks();

        assertEquals(1, copy.size());
        assertEquals("The Example", copy.get(0).getTitle());
    }
    @Test
    public void testGetBookByIdInvalidId() throws InvalidBookIdException {
        Book book = toTest.getAllBookById(-1);

        assertEquals(null, book);
    }

    @Test
    public void testDeleteBookGoldenPath() {
        try {
            toTest.deleteBooks(1);
            assertEquals(0, toTest.getAllBooks().size());
        } catch (InvalidBookIdException ex) {
            fail();
        }
    }

    @Test
    public void testDeleteBookInvalidId() {
        try {
            toTest.deleteBooks(1);
            toTest.deleteBooks(1);
            fail();
        } catch (InvalidBookIdException ex) {

        }
    }

    @Test
    public void testGetBookByIdGoldenPath() throws InvalidBookIdException {
        Book book = toTest.getAllBookById(1);

        assertEquals("The Example", book.getTitle());
        assertEquals(2005, book.getPublicationYear());
    }



}
