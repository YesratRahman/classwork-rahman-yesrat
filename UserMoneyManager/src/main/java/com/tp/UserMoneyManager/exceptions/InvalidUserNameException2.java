package com.tp.UserMoneyManager.exceptions;

public class InvalidUserNameException2 extends Exception{
    public InvalidUserNameException2(String message){
        super(message);
    }
    public InvalidUserNameException2(String message, Throwable innerException){
        super(message, innerException);
    }
}
