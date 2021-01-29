package com.tp.libraryUserStories.persistence;

import com.tp.libraryUserStories.exceptions.InvalidBookIdException;
import com.tp.libraryUserStories.exceptions.NullArgumentException;
import com.tp.libraryUserStories.models.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibraryInMemDao implements LibraryDao{

    private List<Book> allBooks = new ArrayList<>();

    @Override
    public int addBooks(String title, List<String> authors, Integer publicationYear) throws NullArgumentException {
        if(title == null){
            throw new NullArgumentException("Tried to look up Book by null title");
        }

        if(authors == null){
            throw new NullArgumentException("Tried to look up Book by null author");

        }

        if(publicationYear == null){
            throw new NullArgumentException("Tried to look up Book by null publication year");

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
