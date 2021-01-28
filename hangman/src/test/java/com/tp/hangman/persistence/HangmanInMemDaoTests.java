package com.tp.hangman.persistence;

import com.tp.hangman.exceptions.InvalidGameIdException;
import com.tp.hangman.exceptions.NullWordException;
import com.tp.hangman.models.HangmanGame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class HangmanInMemDaoTests {

    @Autowired
    HangmanInMemDao toTest;

    //this will run before each @Test method
    @BeforeEach
    public void setup() throws InvalidGameIdException, NullWordException {
        List<HangmanGame> allGames = toTest.getAllGames();

        for( HangmanGame toRemove : allGames ){
            toTest.deleteGame( toRemove.getGameId() );
        }

        //creates one game with "zebra" and id = 1
        toTest.startGame( "zebra" );

    }

    //golden path test
    //good input -> good output
    @Test
    public void testStartGameGoldenPath() {
        try {
            //1. Arrange (set up inputs)
            String testWord = "test";

            //2. Act (call the method and save any outputs)
            int id = toTest.startGame(testWord);

            //3. Assert (make sure the method did what it was supposed to)
            //Assertions.assertEquals();
            assertEquals(2, id);

            int nextId = toTest.startGame("someword");
            assertEquals(3, nextId);

            HangmanGame validationGame = toTest.getGameById(2);

            assertEquals("test", validationGame.getHiddenWord());
        } catch( NullWordException ex ){
            fail();
        }
    }

    @Test
    public void testStartGameNullWord(){
        try {
            //1. Arrange (set up inputs)
            String testWord = null;

            //2. Act (call the method and save any outputs)
            int id = toTest.startGame(testWord);
            //we only get here if we did NOT throw an exception
            //we WANT an exception here, since we didn't get one
            //we fail the test
            fail();
        } catch( NullWordException ex ){
            //we got the exception we wanted
            //that means we should pass
            //all unit tests pass UNLESS they fail an assert or
            //leak an exception
            //so here we'll just do nothing
        }

        //this will execute with or without an exception
    }
}
