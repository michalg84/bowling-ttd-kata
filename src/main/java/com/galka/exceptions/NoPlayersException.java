package com.galka.exceptions;

public class NoPlayersException extends RuntimeException{
    public NoPlayersException(String message) {
        super(message);
    }
}
