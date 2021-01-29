package com.tp.libraryUserStories.exceptions;

public class NullArgumentException extends Exception{
    public NullArgumentException(String message){
        super(message);
    }
    public NullArgumentException(String message, Throwable throwable){
        super(message, throwable);
    }
}
