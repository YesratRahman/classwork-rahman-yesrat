package com.tp.libraryUserStories.controllers;

import com.tp.libraryUserStories.exceptions.InvalidAuthorsException;
import com.tp.libraryUserStories.exceptions.InvalidBookIdException;
import com.tp.libraryUserStories.exceptions.InvalidPublicationYearException;
import com.tp.libraryUserStories.exceptions.InvalidTitleException;
import com.tp.libraryUserStories.models.Book;
import com.tp.libraryUserStories.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LibraryController {
    @Autowired
    LibraryService service;

    @GetMapping("/book")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/book/{bookId}" )
    public ResponseEntity getBooksById(@PathVariable Integer bookId){
        try {
            return ResponseEntity.ok(service.getAllBookById(bookId));
        } catch (InvalidBookIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addBooks")
    public ResponseEntity addBooks(@RequestBody BookRequest request){
        Book toReturn = null;
        try{
            toReturn = service.addBooks( request.getTitle(), request.getAuthors(), request.getPublicationYear());
        } catch(InvalidAuthorsException | InvalidTitleException | InvalidPublicationYearException exception ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
        return ResponseEntity.ok(toReturn);
    }

    @GetMapping("/book/title/{title}")
    public ResponseEntity getBooksByTitle(@PathVariable String title) throws InvalidTitleException {
        Book toReturn = null;
        try{
            return ResponseEntity.ok(service.getBooksByTitle(title));
        } catch(InvalidTitleException exception ){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }


    @GetMapping("/book/author/{author}")
    public ResponseEntity getBooksByAuthor(@PathVariable String author) throws InvalidAuthorsException {
        Book toReturn = null;
        try{
            return ResponseEntity.ok(service.getBooksByAuthor(author));
        } catch(InvalidAuthorsException exception ){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/book/year/{year}")
    public ResponseEntity getBooksByYear(@PathVariable Integer year) throws InvalidPublicationYearException {
        Book toReturn = null;
        try{
            return ResponseEntity.ok(service.getBooksByYear(year));
        } catch(InvalidPublicationYearException exception ){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("update/title/{bookId}")
    public ResponseEntity updateBookByTitle(@PathVariable Integer bookId, @RequestBody BookRequest requestTitle){
        Book toReturn = null;
        try{
            toReturn = service.updateBookByTitle(bookId, requestTitle.getTitle());
        }catch(InvalidTitleException| InvalidBookIdException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
        return ResponseEntity.ok(toReturn);
    }

    @PutMapping("update/author/{bookId}")
    public ResponseEntity updateBookByAuthor(@PathVariable Integer bookId, @RequestBody BookRequest requestAuthor){
        Book toReturn = null;
        try{
            toReturn = service.updateBookByAuthor(bookId, requestAuthor.getAuthors());
        }catch(InvalidAuthorsException| InvalidBookIdException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
        return ResponseEntity.ok(toReturn);
    }

    @PutMapping("update/year/{bookId}")
    public ResponseEntity updateBookByPublicationYear(@PathVariable Integer bookId, @RequestBody BookRequest requestYear){
        Book toReturn = null;
        try{
            toReturn = service.updateBookByPublicationYear(bookId, requestYear.getPublicationYear());
        }catch(InvalidPublicationYearException| InvalidBookIdException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
        return ResponseEntity.ok(toReturn);
    }

    @DeleteMapping("/delete/{bookId}")
    public String deleteBook( @PathVariable Integer bookId ){
        try {
            service.deleteBooks(bookId);
            return "Book with id " + bookId + " successfully deleted.";
        } catch (InvalidBookIdException e) {
            return e.getMessage();
        }
    }



}

