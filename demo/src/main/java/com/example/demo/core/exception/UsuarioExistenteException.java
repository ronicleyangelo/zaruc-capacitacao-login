package com.example.demo.core.exception;

public class UsuarioExistenteException extends Exception{
    public UsuarioExistenteException(String message) {
        super(message);
    }

    public UsuarioExistenteException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
