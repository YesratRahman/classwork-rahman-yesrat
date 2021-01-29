package com.tp.libraryUserStories.exceptions;

public class InvalidBookIdException extends Exception{
    public InvalidBookIdException(String message){
        super(message);
    }

    public InvalidBookIdException(String message, Throwable throwable){
        super(message, throwable);
    }
}
