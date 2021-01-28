package com.tp.hangman.exceptions;

public class InvalidGameIdException extends Exception {
    public InvalidGameIdException( String message ){
        super( message );
    }

    public InvalidGameIdException( String message, Throwable innerException ){
        super( message, innerException);
    }

    public void someWeirdExceptionMethod(){

    }
}
