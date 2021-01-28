package com.tp.hangman.exceptions;

public class InvalidGuessException extends Exception {

    public InvalidGuessException( String message) {
        super( message );
    }

    public InvalidGuessException( String message, Throwable innerException  ){
        super( message, innerException );
    }

}
