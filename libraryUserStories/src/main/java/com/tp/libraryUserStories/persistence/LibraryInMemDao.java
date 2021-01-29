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
        if(title == null || title.equals("")){
            throw new InvalidTitleException("Tried to look up Book by null title");
        }

        if(publicationYear == null){
            throw new InvalidPublicationYearException("Tried to look up Book by null publication year");

        }
        if(authors == null){
            throw new InvalidAuthorsException("Tried to look up Book by null author");
        }

        int newYear = LocalDate.now().getYear();

        if(publicationYear > newYear){
            throw new InvalidPublicationYearException("The year can not be more than recent year");
        }

        if(authors.size() == 0){
            throw new InvalidAuthorsException("Each book should have one author");
        }


        for(String str: authors){
            if(str == null){
                throw new InvalidAuthorsException("Tried to look up Book by null author");
            }
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
        if(title == null || title.equals("")){
            throw new InvalidTitleException("Book can not have a null title or a empty String");
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
        if(author == null || author ==""){
            throw new InvalidAuthorsException("Author can not be null or empty");
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
        int newYear = LocalDate.now().getYear();

        if(year > newYear){
            throw new InvalidPublicationYearException("The year can not be more than the  recent year");
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
    public Book updateBook(Integer id, Book newBook) throws InvalidTitleException, InvalidAuthorsException, InvalidPublicationYearException, InvalidBookIdException {
       if(id == null){
           throw new InvalidBookIdException("A book with null id can not be updated");
       }

       for(Book book : allBooks){
           if(book.getBookId().equals(id)){
               if(!newBook.getTitle().equals("")){
                   book.setTitle(newBook.getTitle());
               }
               if(book.getAuthors().size() != 0){
                   Book toCopy = new Book(newBook);
                   for(String author : newBook.getAuthors()){
                       if(!author.equals("")){
                           toCopy.getAuthors().add(author);
                       }
                   }
                   if(toCopy.getAuthors().size() == 0){
                       throw new InvalidAuthorsException("Book can not be updated without author");
                   }
                   else {
                       book.setAuthors(toCopy.getAuthors());
                   }
               }
               if(newBook.getPublicationYear() != null){
                   book.setPublicationYear(newBook.getPublicationYear());
               }
               return book;
           }
       }
       throw new InvalidBookIdException("Can not be updated without any " + id);


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
