package com.example.SkyTravel.exception;

public class InvalidIdException extends RuntimeException{

    public InvalidIdException(String message){
        super(message);
    }
}