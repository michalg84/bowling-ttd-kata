package com.galka.controler;

class NoPlayersException extends RuntimeException{
    public NoPlayersException(String message) {
        super(message);
    }
}
