package com.tp.libraryUserStories.exceptions;

public class InvalidAuthorsException extends Exception{
    public InvalidAuthorsException(String message){
        super(message);
    }
    public InvalidAuthorsException(String message, Throwable throwable){
        super(message, throwable);
    }
}
