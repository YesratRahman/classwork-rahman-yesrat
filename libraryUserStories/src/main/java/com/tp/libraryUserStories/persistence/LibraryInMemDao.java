package com.tp.libraryUserStories.persistence;

import com.tp.libraryUserStories.exceptions.*;
import com.tp.libraryUserStories.models.Book;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryInMemDao implements LibraryDao{

    private List<Book> allBooks = new ArrayList<>();

    public LibraryInMemDao(){
        Book b = new Book(1, "title1", new ArrayList<>(), 2021);
        this.allBooks.add(b);
    }
    @Override
    public List<Book> getAllBooks() {
        List<Book> copyList = new ArrayList<>();
        for( Book toCopy : allBooks ){
            copyList.add( new Book(toCopy));
        }
        return copyList;
    }

    @Override
    public Book getAllBookById(Integer id) {
        Book toReturn = null;

        for( Book toCheck : allBooks ){
            if( toCheck.getBookId().equals(id) ){
                toReturn = new Book(toCheck);
                break;
            }
        }

        return toReturn;
    }

    @Override
    public int addBooks(String title, List<String> authors, Integer publicationYear)
            throws InvalidTitleException,
            InvalidAuthorsException,
            InvalidPublicationYearException
    {
        if(title == null ){
            throw new InvalidTitleException("Tried to add Book by null title");
        }

        if(publicationYear == null){
            throw new InvalidPublicationYearException("Tried to add Book by null publication year");

        }
        if(authors == null){
            throw new InvalidAuthorsException("Tried to add Book by null author");
        }


        int id = 0;

        for( Book toCheck : allBooks ){
            if( toCheck.getBookId() > id ){
                id = toCheck.getBookId();
            }
        }

        id++;

        Book toAdd = new Book(id, title, authors, publicationYear);
        allBooks.add( toAdd );
        return id;
    }


    @Override
    public List<Book> getBooksByTitle(String title) throws InvalidTitleException {
        if(title == null){
            throw new InvalidTitleException("Book can not have a null title");
        }
        List<Book> newBook = new ArrayList<>();
        for(Book toCopy : allBooks){
            if(toCopy.getTitle().toLowerCase().contains(title.toLowerCase())){
                newBook.add(new Book(toCopy));
            }
        }
        return newBook;
    }

    @Override
    public List<Book> getBooksByAuthors(String author) throws InvalidAuthorsException {
        if(author == null){
            throw new InvalidAuthorsException("Author can not be null");
        }
        List<Book> newBook = new ArrayList<>();
        for(Book toCopy: allBooks){
            for(String newAuthor : toCopy.getAuthors()){
                if(newAuthor.toLowerCase().contains(author.toLowerCase())){
                    newBook.add(new Book(toCopy));
                    break;
                }

            }
        }
        return newBook;
    }

    @Override
    public List<Book> getBooksByYear(Integer year) throws InvalidPublicationYearException {

        if(year == null){
            throw new InvalidPublicationYearException("Year can not be null");
        }

        List<Book> newBook = new ArrayList<>();
        for(Book toCopy: allBooks){
            if(toCopy.getPublicationYear().equals(year)){
                newBook.add(new Book(toCopy));
            }
        }
        return newBook;
    }

    @Override
    public void updateBook(Book newBook) {
        for(int i = 0; i < allBooks.size(); i++){
            if(allBooks.get(i).getBookId().equals(newBook.getBookId())){
                allBooks.set(i, new Book(newBook));
            }
        }
    }

    @Override
    public void deleteBooks(Integer bookId) throws InvalidBookIdException {
        int removeIndex = -1;

        for( int i = 0; i < allBooks.size(); i++ ){
            if( allBooks.get(i).getBookId().equals(bookId)){
                removeIndex = i;
                break;
            }
        }
        if( removeIndex != -1 ){
            allBooks.remove(removeIndex);
        } else {
            throw new InvalidBookIdException("Could not find book with id " + bookId + "to delete.");
        }
    }

}
