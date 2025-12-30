package com.cakeservice.exceptions;

public class InvalidRecipeNameException extends RuntimeException{
    public InvalidRecipeNameException(String message) {
        super(message);
    }
}
