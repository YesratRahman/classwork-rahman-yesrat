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
    public void testAddBooksGoldenPath() throws InvalidAuthorsException, InvalidPublicationYearException, InvalidTitleException, InvalidBookIdException {

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

    }

    @Test
    public void testAddBooksNullTitle() {
        try {
            Book book = toTest.addBooks(null, Arrays.asList("The prince", "author"), 2004);
            fail();
        } catch (InvalidAuthorsException | InvalidPublicationYearException ex) {
            fail();
        } catch (InvalidTitleException ex) {
        }
    }

    @Test
    public void testAddBooksEmptyTitle() {
        try {
            Book book = toTest.addBooks("", Arrays.asList("author1", "author2"), 2004);
            fail();
        } catch (InvalidAuthorsException | InvalidPublicationYearException ex) {
            fail();
        } catch (InvalidTitleException ex) {
        }
    }
    @Test
    public void testAddBooksBlankTitle() {
        try {
            Book book = toTest.addBooks(" ", Arrays.asList("author1", "author2"), 2004);
            fail();
        } catch (InvalidAuthorsException | InvalidPublicationYearException ex) {
            fail();
        } catch (InvalidTitleException ex) {
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
    public void testAddBookBlankAuthors() {
        try {
            Book book = toTest.addBooks("The Prince", Arrays.asList(" "), 2010);
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
        }
    }

    @Test
    public void testAddAuthorListWithOneEmptyAuthor() {
        try {
            Book book = toTest.addBooks("One title", Arrays.asList("two title", "", "author"), 2010);
            fail();
        } catch (InvalidTitleException | InvalidPublicationYearException ex) {
            fail();
        } catch (InvalidAuthorsException ex) {
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
    public void testAddBookInvalidYear() {
        try {
            Book book = toTest.addBooks("The examples", Arrays.asList("author1", "author2"), 1453);
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
    public void testUpdateBookByTitleGoldenPath(){
        try{
            Book toBook = toTest.updateBookByTitle(1, "The King");
            assertEquals("The King", toTest.getAllBookById(1).getTitle());
            assertEquals("The King", toBook.getTitle());
        }catch (InvalidTitleException | InvalidBookIdException exception){
            fail();
        }
    }
    @Test
    public void testUpdateBookGoldenPath() throws InvalidAuthorsException, InvalidPublicationYearException, InvalidTitleException, InvalidBookIdException {
        int id = toTest.addBooks("new Book", Arrays.asList("author1", "author2"), 2010).getBookId();
        assertEquals(2, id);
        toTest.updateBookByPublicationYear(2,2021);
        toTest.updateBookByAuthor(2, Arrays.asList("Author1"));
        toTest.updateBookByTitle(2, "The Prince");
        Book validation = toTest.getAllBookById(2);
        assertEquals(2021, validation.getPublicationYear());
        assertEquals(Arrays.asList("Author1"), validation.getAuthors());
        assertEquals("The Prince", validation.getTitle());
    }

    @Test
    public void testUpdateBookByNullTitle(){
        try{
            Book toBook = toTest.updateBookByTitle(1, null);
            fail();
        }catch (InvalidBookIdException e){
            fail();
        }catch (InvalidTitleException e){
        }
    }

    @Test
    public void testUpdateBookByEmptyTitle(){
        try{
            Book toBook = toTest.updateBookByTitle(1, "");
            fail();
        }catch (InvalidBookIdException e){
            fail();
        }catch (InvalidTitleException e){
        }
    }

    @Test
    public void testUpdateBookByBlankTitle(){
        try{
            Book toBook = toTest.updateBookByTitle(1, " ");
            fail();
        }catch (InvalidBookIdException e){
            fail();
        }catch (InvalidTitleException e){
        }
    }


    @Test
    public void testUpdateBookByAuthorGoldenPath(){
        try{
            Book toBook = toTest.updateBookByAuthor(1, Arrays.asList("Author1"));
            assertEquals("Author1", toTest.getAllBookById(1).getAuthors().get(0));
            assertEquals("Author1", toBook.getAuthors().get(0));
        }catch (InvalidAuthorsException | InvalidBookIdException exception){
            fail();
        }
    }

    @Test
    public void testUpdateBookByOneEmptyListAuthor(){
        try{
            Book toBook = toTest.updateBookByAuthor(1, Arrays.asList("Author1", ""));
            fail();
        }catch(InvalidBookIdException ex){
            fail();
        }
        catch (InvalidAuthorsException ex){
        }
    }

    @Test
    public void testUpdateBookByOneBlankListAuthor(){
        try{
            Book toBook = toTest.updateBookByAuthor(1, Arrays.asList("Author1", " "));
            fail();
        }catch(InvalidBookIdException ex){
            fail();
        }
        catch (InvalidAuthorsException ex){
        }
    }
    @Test
    public void testUpdateBookByNullListAuthor(){
        try{
            Book toBook = toTest.updateBookByAuthor(1, Arrays.asList(null, "Author1"));
            fail();
        }catch(InvalidBookIdException ex){
            fail();
        }
        catch (InvalidAuthorsException ex){
        }
    }

    @Test
    public void testUpdateBookByNullAuthor(){
        try{
            Book toBook = toTest.updateBookByAuthor(1, null);
            fail();
        }catch (InvalidBookIdException e){
            fail();
        }catch (InvalidAuthorsException e){
        }
    }

    @Test
    public void testUpdateBookByEmptyAuthor(){
        try{
            Book toBook = toTest.updateBookByAuthor(1, Arrays.asList());
            fail();
        }catch (InvalidBookIdException e){
            fail();
        }catch (InvalidAuthorsException e){
        }
    }

    @Test
    public void testUpdateBookByBlankAuthor(){
        try{
            Book toBook = toTest.updateBookByAuthor(1, Arrays.asList(" "));
            fail();
        }catch (InvalidBookIdException e){
            fail();
        }catch (InvalidAuthorsException e){
        }
    }

    @Test
    public void testUpdateBookByYearGoldenPath(){
        try{
            Book toBook = toTest.updateBookByPublicationYear(1, 2005);
            assertEquals(2005, toTest.getAllBookById(1).getPublicationYear());
            assertEquals(2005, toBook.getPublicationYear());
        }catch (InvalidPublicationYearException | InvalidBookIdException exception){
            fail();
        }
    }

    @Test
    public void testUpdateBookByNullYear(){
        try{
            Book toBook = toTest.updateBookByPublicationYear(1, null);
            fail();
        }catch (InvalidBookIdException e){
            fail();
        }catch (InvalidPublicationYearException e){
        }
    }

    @Test
    public void testUpdateBookByInvalidYear(){
        try{
            Book toBook = toTest.updateBookByPublicationYear(1, 2030);
            fail();
        }catch (InvalidBookIdException e){
            fail();
        }catch (InvalidPublicationYearException e){
        }
    }

    @Test
    public void testUpdateBookByTitleInvalidBookId(){
        try{
            Book toBook = toTest.updateBookByTitle(-100, "The king");
            fail();
        }catch (InvalidTitleException e){
            fail();
        }catch (InvalidBookIdException e){
        }
    }

    @Test
    public void testUpdateBookByYearInvalidBookId(){
        try{
            Book toBook = toTest.updateBookByPublicationYear(-100, 2005);
            fail();
        }catch (InvalidPublicationYearException e){
            fail();
        }catch (InvalidBookIdException e){
        }
    }

    @Test
    public void testUpdateBookByAuthorInvalidBookId(){
        try{
            Book toBook = toTest.updateBookByAuthor(-100, Arrays.asList("The author"));
            fail();
        }catch (InvalidAuthorsException e){
            fail();
        }catch (InvalidBookIdException e){
        }
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

    public void testGetBookGoldenPath() throws InvalidTitleException, InvalidPublicationYearException, InvalidAuthorsException {
        toTest.addBooks("title", Arrays.asList("author1"), 2015);
        toTest.addBooks("title new", Arrays.asList("author", "new author"), 2010);

        //Title
        List<Book> book = toTest.getBooksByTitle("title");
        assertEquals(2, book.size());

        Book book1 = book.get(0);
        assertEquals(2, book1.getBookId());
        assertEquals("title", book1.getTitle());
        assertEquals("author1", book1.getAuthors().get(0));
        assertEquals(2015, book1.getPublicationYear());

        Book book2 = book.get(1);
        assertEquals(3, book2.getBookId());
        assertEquals("title new", book2.getTitle());
        assertEquals("author", book2.getAuthors().get(0));
        assertEquals("new author", book2.getAuthors().get(1));
        assertEquals(2010, book2.getPublicationYear());

        //Title
        book = toTest.getBooksByTitle("book");
        assertEquals(0, book.size());

        //Author
        book = toTest.getBooksByAuthor("author4");
        assertEquals(0, book.size());

        book = toTest.getBooksByAuthor("author");
        assertEquals(2, book.size());

        Book book3 = book.get(0);
        assertEquals(2, book3.getBookId());
        assertEquals("title", book3.getTitle());
        assertEquals("author1", book3.getAuthors().get(0));
        assertEquals(2015, book3.getPublicationYear());

        Book book4 = book.get(1);
        assertEquals(3, book4.getBookId());
        assertEquals("title new", book4.getTitle());
        assertEquals("author", book4.getAuthors().get(0));
        assertEquals("new author", book4.getAuthors().get(1));
        assertEquals(2010, book4.getPublicationYear());

        //Year
        book = toTest.getBooksByYear(2020);
        assertEquals(0, book.size());

        book = toTest.getBooksByYear(2010);
        assertEquals(1, book.size());

        Book book5 = book.get(0);
        assertEquals(2, book3.getBookId());
        assertEquals("title", book3.getTitle());
        assertEquals("author1", book3.getAuthors().get(0));
        assertEquals(2015, book3.getPublicationYear());
    }

    @Test
    public void testGetBookByNullTitle(){
        try
        {
            toTest.getBooksByTitle(null);
            fail();
        } catch (InvalidTitleException e) {

        }

    }

    @Test
    public void testGetBookByNullAuthor(){
        try
        {
            toTest.getBooksByAuthor(null);
            fail();
        } catch (InvalidAuthorsException e) {

        }
    }

    @Test
    public void testBookByNullYear(){
        try
        {
            toTest.getBooksByYear(null);
            fail();
        } catch (InvalidPublicationYearException e) {

        }

    }





    @Test
    public void testGetBookByEmptyTitle(){
        try
        {
            toTest.getBooksByTitle("");
            fail();
        } catch (InvalidTitleException e) {

        }

    }

    @Test
    public void testGetBookByBlankTitle(){
        try
        {
            toTest.getBooksByTitle(" ");
            fail();
        } catch (InvalidTitleException e) {

        }

    }

    @Test
    public void testGetBookByBlankAuthor(){
        try
        {
            toTest.getBooksByAuthor(" ");
            fail();
        } catch (InvalidAuthorsException e) {

        }
    }
    @Test
    public void testGetBookByEmptyAuthor(){
        try
        {
            toTest.getBooksByAuthor("");
            fail();
        } catch (InvalidAuthorsException e) {

        }
    }

    @Test
    public void testBookByInvalidYear() {
        try {
            toTest.getBooksByYear(1453);
            fail();
        } catch (InvalidPublicationYearException e) {

        }
    }


}
