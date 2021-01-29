package com.tp.libraryUserStories.exceptions;

public class InvalidPublicationYearException extends Exception{
    public InvalidPublicationYearException(String message){
        super(message);
    }
    public InvalidPublicationYearException(String message, Throwable throwable){
        super(message, throwable);
    }
}
