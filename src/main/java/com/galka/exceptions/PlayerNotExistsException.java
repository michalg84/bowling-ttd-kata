package com.galka.exceptions;

public class PlayerNotExistsException extends RuntimeException {

    public PlayerNotExistsException(String message) {
        super(message);
    }
}
