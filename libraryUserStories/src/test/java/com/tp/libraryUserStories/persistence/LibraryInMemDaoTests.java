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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LibraryInMemDaoTests {

    @Autowired
    LibraryDao toTest;

    @BeforeEach
    public void setUp() throws InvalidBookIdException, InvalidTitleException, InvalidAuthorsException, InvalidPublicationYearException{
        List<Book> allBooks = toTest.getAllBooks();

        for( Book toRemove : allBooks ){
            toTest.deleteBooks( toRemove.getBookId());
        }
        toTest.addBooks("The Example", Arrays.asList("Tom Taylor"), 2005);
    }

    @Test
    public void testAddBooksGoldenPath(){
        try{
            int newId = toTest.addBooks("The little Prince", Arrays.asList("Antoine"),1943);
            assertEquals(2, newId);

            int id = toTest.addBooks("book2", Arrays.asList("author1", "author2" ), 2004);
            assertEquals(3,id);
            Book newBook = toTest.getAllBookById(3);
            assertEquals(3, newBook.getBookId());
            assertEquals("book2", newBook.getTitle());
            assertEquals(2004, newBook.getPublicationYear());
            List<String> authors = newBook.getAuthors();
            assertEquals(2,newBook.getAuthors().size());
            assertEquals("author1", newBook.getAuthors().get(0));
            assertEquals("author2", newBook.getAuthors().get(1));

        }catch(InvalidTitleException| InvalidAuthorsException | InvalidPublicationYearException exception){
            fail();
        }

    }
    @Test
    public void testGetBooksByTitleGoldenPath(){
        try{
            assertEquals(1, toTest.getBooksByTitle("The Example").size());
            assertEquals(1, toTest.getBooksByTitle(" Example").size());
            assertEquals(1, toTest.getBooksByTitle("Example").get(0).getBookId());
        } catch (InvalidTitleException e) {
           fail();
        }
    }

    @Test
    public void testAddBooksByNullTitle(){
        try {
            List<Book> book = toTest.getBooksByTitle(null);
            fail();
        } catch(InvalidTitleException e){
            }
        }


    @Test
   public void testAddBooksByEmptyTitle(){
        try{
            List<Book> book = toTest.getBooksByTitle("");
            fail();
        }catch(InvalidTitleException e){

        }
    }


    @Test
    public void testAddBooksByNullAuthor(){
        try {
            List<Book> book = toTest.getBooksByAuthors(null);
            fail();
        } catch(InvalidAuthorsException e){
        }
    }


    @Test
    public void testAddBooksByEmptyAuthor(){
        try{
            List<Book> book = toTest.getBooksByAuthors("");
            fail();
        }catch(InvalidAuthorsException e){

        }
    }

    @Test
    public void testAddBookByNullYear(){
        try{
            int bookId = toTest.addBooks("title", Arrays.asList("author"), null);
            fail();
        } catch (InvalidTitleException | InvalidAuthorsException e) {
            fail();
        } catch (InvalidPublicationYearException e) {

        }
    }



    @Test
    public void testAddBookByInvalidYear(){
        try{
            int bookId = toTest.addBooks("title1", Arrays.asList("author1"), 2022);
            fail();
        } catch (InvalidTitleException | InvalidAuthorsException e) {
            fail();
        } catch (InvalidPublicationYearException e) {

        }
    }

    //@Test


}






