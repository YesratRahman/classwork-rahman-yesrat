package com.tp.hangman.exceptions;

public class NullWordException extends Exception {
    public NullWordException( String message ){
        super( message );
    }

    public NullWordException( String message, Throwable innerException ){
        super( message, innerException );
    }
}
