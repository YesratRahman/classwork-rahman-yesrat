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

@RestController
public class LibraryController {
    @Autowired
    LibraryService service;

    @GetMapping("/book")
    public List<Book> getAllGames(){
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
    public List<Book> getBooksByTitle(@PathVariable String title) throws InvalidTitleException {
        return service.getBooksByTitle(title);
    }

    @GetMapping("/book/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) throws InvalidAuthorsException {
        return service.getBooksByAuthor(author);
    }

    @GetMapping("/book/year/{year}")
    public List<Book> getBooksByYear(@PathVariable Integer year) throws InvalidPublicationYearException {
        return service.getBooksByYear(year);
    }

    @PutMapping("/book/{bookId}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book newBook) throws InvalidPublicationYearException, InvalidAuthorsException, InvalidTitleException, InvalidBookIdException {
        return service.updateBook(id, newBook);
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

