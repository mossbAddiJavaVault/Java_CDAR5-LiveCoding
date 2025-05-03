package com.exceptions;


public class LivreNonDisponibleException extends BibliothequeException {

    public LivreNonDisponibleException(String message) {
        super(message);
    }

    public LivreNonDisponibleException(String message,Throwable cause) {
        super(message, cause);
    }


}
