package com.galka.controler;

public class PlayerExistsExcption extends RuntimeException {
    public PlayerExistsExcption(String message) {
        super(message);
    }
}
