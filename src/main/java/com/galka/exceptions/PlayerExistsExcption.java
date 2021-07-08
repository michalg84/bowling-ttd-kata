package com.galka.exceptions;

public class PlayerExistsExcption extends RuntimeException {
    public PlayerExistsExcption(String message) {
        super(message);
    }
}
