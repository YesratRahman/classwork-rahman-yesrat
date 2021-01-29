package com.tp.libraryUserStories.exceptions;

public class InvalidTitleException extends Exception{
    public InvalidTitleException(String message){
        super(message);
    }
    public InvalidTitleException(String message, Throwable throwable){
        super(message, throwable);
    }
}
