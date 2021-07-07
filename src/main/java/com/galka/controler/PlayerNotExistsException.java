package com.galka.controler;

public class PlayerNotExistsException extends RuntimeException {

    public PlayerNotExistsException(String message) {
        super(message);
    }
}
