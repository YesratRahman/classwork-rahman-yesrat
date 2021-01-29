package com.tp.libraryUserStories.controllers;

import com.tp.libraryUserStories.exceptions.InvalidBookIdException;
import com.tp.libraryUserStories.models.Book;
import com.tp.libraryUserStories.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    LibraryService service;

    @GetMapping("/book")
    public List<Book> getAllGames(){
        return service.getAllBooks();
    }

    @GetMapping( "/book/{bookId}" )
    public ResponseEntity getBooksById(@PathVariable Integer bookId){
//        try {
//            return ResponseEntity.ok(service.getAllBookById(bookId));
//        } catch (InvalidBookIdException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }

throw new UnsupportedOperationException(); 
    }


}
