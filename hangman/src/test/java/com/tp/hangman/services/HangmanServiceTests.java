package com.tp.hangman.services;

import com.tp.hangman.exceptions.InvalidGameIdException;
import com.tp.hangman.exceptions.InvalidGuessException;
import com.tp.hangman.exceptions.NullGuessException;
import com.tp.hangman.exceptions.NullWordException;
import com.tp.hangman.models.HangmanViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class HangmanServiceTests {

    @Autowired
    HangmanService service;

    @BeforeEach
    public void setup() throws InvalidGameIdException {

        List<HangmanViewModel> allGames = service.getAllGames();

        for( HangmanViewModel toDelete : allGames ){
            service.deleteGame( toDelete.getGameId() );
        }
    }

    @Test
    public void startGameTestGoldenPath(){

        //1. Arrange
        //with seed 12345, we should get "education"
        Rng.reSeed(12345);
        //2. Act
        try {
            HangmanViewModel game =  service.startGame();
//            service.makeGuess( game.getGameId(), "a");
//            service.makeGuess( game.getGameId(), "b");
//
//            service.makeGuess( game.getGameId(), "c");
//
//            service.makeGuess( game.getGameId(), "d");
//
//            service.makeGuess( game.getGameId(), "e");
//
//            service.makeGuess( game.getGameId(), "f");
//
//            service.makeGuess( game.getGameId(), "g");
//
//            service.makeGuess( game.getGameId(), "h");
//
//            service.makeGuess( game.getGameId(), "i");
//
//            service.makeGuess( game.getGameId(), "j");
//
//            service.makeGuess( game.getGameId(), "k");
//
//            service.makeGuess( game.getGameId(), "l");
//
//            service.makeGuess( game.getGameId(), "m");
//
//            service.makeGuess( game.getGameId(), "n");
//
//            service.makeGuess( game.getGameId(), "o");
//            service.makeGuess( game.getGameId(), "p");
//            service.makeGuess( game.getGameId(), "q");
//            service.makeGuess( game.getGameId(), "r");
//            service.makeGuess( game.getGameId(), "s");
//            service.makeGuess( game.getGameId(), "t");
//            service.makeGuess( game.getGameId(), "u");
//            service.makeGuess( game.getGameId(), "v");
//            service.makeGuess( game.getGameId(), "w");
//            service.makeGuess( game.getGameId(), "x");
//            service.makeGuess( game.getGameId(), "y");
//            service.makeGuess( game.getGameId(), "z");

            //game = service.getGameById( game.getGameId() );

            assertEquals( 1, game.getGameId());
            assertEquals("_________", game.getPartialWord());
            assertTrue( game.getGuessedLetters().isEmpty() );


        } catch (NullWordException e) {
            fail();
        }
        //3. Assert

    }

    @Test
    public void makeGuessTestGoldenPath(){
        //1. Arrange
        //with seed 12345, we should get "education"
        Rng.reSeed(12345);
        try {
            HangmanViewModel game = service.startGame();
            HangmanViewModel gameAfterMiss = service.makeGuess(game.getGameId(), "z");
            HangmanViewModel gameAfterHit = service.makeGuess( game.getGameId(), "e");

            assertEquals( "_________" , gameAfterMiss.getPartialWord() );
            assertEquals( 1, gameAfterMiss.getGuessedLetters().size());
            assertEquals( 'z', gameAfterMiss.getGuessedLetters().get(0));

            assertEquals( "e________", gameAfterHit.getPartialWord());
            assertEquals( 2, gameAfterHit.getGuessedLetters().size());
            assertEquals( 'z', gameAfterHit.getGuessedLetters().get(0));
            assertEquals( 'e', gameAfterHit.getGuessedLetters().get(1) );

        } catch (NullWordException | NullGuessException | InvalidGuessException | InvalidGameIdException e) {
            fail();
        }

    }

    @Test
    public void makeGuessTestNullGuess(){
        //1. Arrange
        //with seed 12345, we should get "education"
        Rng.reSeed(12345);
        try {
            HangmanViewModel game = service.startGame();
            HangmanViewModel gameAfterMiss = service.makeGuess(game.getGameId(), null);
            fail();
        } catch (NullWordException | InvalidGuessException | InvalidGameIdException e) {
            fail();
        } catch (NullGuessException e){
            //do nothing because this is the specific exception we WANT
        }

    }

    @Test
    public void makeGuessTestGuessTooBig(){
        //1. Arrange
        //with seed 12345, we should get "education"
        Rng.reSeed(12345);
        try {
            HangmanViewModel game = service.startGame();
            HangmanViewModel gameAfterMiss = service.makeGuess(game.getGameId(), "abcdef");
            fail();
        } catch (NullWordException | NullGuessException | InvalidGameIdException e) {
            fail();
        } catch (InvalidGuessException e){
            //do nothing because this is the specific exception we WANT
        }

    }

    @Test
    public void makeGuessTestInvalidGameId(){
        //1. Arrange
        //with seed 12345, we should get "education"
        Rng.reSeed(12345);
        try {
            HangmanViewModel game = service.startGame();
            HangmanViewModel gameAfterMiss = service.makeGuess(999, "a");
            fail();
        } catch (NullWordException | NullGuessException | InvalidGuessException e) {
            fail();
        } catch (InvalidGameIdException e){
            //do nothing because this is the specific exception we WANT
        }

    }

    @Test
    public void makeGuessTestNullGameId(){
        //1. Arrange
        //with seed 12345, we should get "education"
        Rng.reSeed(12345);
        try {
            HangmanViewModel game = service.startGame();
            HangmanViewModel gameAfterMiss = service.makeGuess(null, "a");
            fail();
        } catch (NullWordException | NullGuessException | InvalidGuessException e) {
            fail();
        } catch (InvalidGameIdException e){
            //do nothing because this is the specific exception we WANT
        }

    }




}
