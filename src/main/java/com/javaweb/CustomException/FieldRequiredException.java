package com.javaweb.CustomException;

public class FieldRequiredException extends RuntimeException{
    public FieldRequiredException(String string) {
        super(string);
    }
}
