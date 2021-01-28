package com.tp.hangman.controllers;

import com.tp.hangman.exceptions.NullWordException;
import com.tp.hangman.models.HangmanViewModel;
import com.tp.hangman.services.HangmanService;
import com.tp.hangman.exceptions.InvalidGameIdException;
import com.tp.hangman.exceptions.InvalidGuessException;
import com.tp.hangman.exceptions.NullGuessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//this will provide two methods
//getGameById (should show the word with unguessed letters hidden and all guessed letters)
//guessLetter (should take a game and a letter to guess for that game)
@RestController
public class HangmanController {

    //autowired will automatically bring in any
    // "bean" which is defined as a "component"
    // several annotations derive from component
    // including @Service and @Repository
    // but we can also do @Component
    @Autowired
    HangmanService service;

    //CRUD
    //Create
    //      POST - inserting new data into a system
    //              will typically make use of the "body"
    //              of the request to send data rather than the url
    //Read (read one and read all)
    //      GET - retrieving data from a system
    //Update
    //      PUT - editing data already in a system
    //Delete
    //      DELETE - removing data from a system

    @GetMapping("/game")
    public List<HangmanViewModel> getAllGames(){
        return service.getAllGames();
    }

    @GetMapping( "/game/{gameId}" )
    public HangmanViewModel  getGameById(@PathVariable Integer gameId){
        return service.getGameById( gameId );
    }

    @PutMapping ("/edit")
    public HangmanViewModel editSecretWord( @RequestBody UpdateWordRequest request ){
        return service.editSecretWord( request.getGameId(), request.getNewWord() );
    }

//    @GetMapping("/game/{gameId}/guess/{guess}")
//    public ResponseEntity guessLetter( @PathVariable String guess, @PathVariable Integer gameId )
//    {
//
//        HangmanViewModel toReturn = null;
//
//        try{
//            toReturn = service.makeGuess( gameId, guess );
//        } catch( NullGuessException | InvalidGuessException | InvalidGameIdException ex ){
//
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//        }
//
//        return ResponseEntity.ok(toReturn);
//
//    }

    @PostMapping("/guess")
    public ResponseEntity guessLetter(@RequestBody GuessRequest request )
    {
        HangmanViewModel toReturn = null;

        try{
            toReturn = service.makeGuess( request.getGameId(), request.getGuess() );
        } catch( NullGuessException | InvalidGuessException | InvalidGameIdException ex ){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

        return ResponseEntity.ok(toReturn);

    }

    @PostMapping("/begin")
    public HangmanViewModel startGame(){
        HangmanViewModel game = null;
        try {
            game = service.startGame();
        } catch (NullWordException e) {
            e.printStackTrace();
        }

        return game;
    }

    @DeleteMapping("/delete/{gameId}")
    public String deleteGame( @PathVariable Integer gameId ){
        try {
            service.deleteGame( gameId );
            return "Game " + gameId + " successfully deleted.";
        } catch (InvalidGameIdException e) {
            return e.getMessage();
        }

    }


}
