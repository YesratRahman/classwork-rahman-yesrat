package com.tp.libraryUserStories.services;

import com.tp.libraryUserStories.exceptions.NullArgumentException;
import com.tp.libraryUserStories.models.Book;
import com.tp.libraryUserStories.persistence.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryService {

    @Autowired
    LibraryDao libraryDao;

    public Book getAllBooks(String title, List<String > authors, Integer year) throws NullArgumentException {
        int id = libraryDao.addBooks(title, authors, year);

        return libraryDao.getAllBookById(id);
    }

    public List<Book> getAllBooks(){
        return libraryDao.getAllBooks();
    }

    public Book getAllBookById(Integer id){
        return libraryDao.getAllBookById(id);
    }

}
