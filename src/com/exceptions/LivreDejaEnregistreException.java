package com.exceptions;

public class LivreDejaEnregistreException extends BibliothequeException {

    
    public LivreDejaEnregistreException(String message) {
        super(message);
    }

    public LivreDejaEnregistreException(String message, Throwable cause) {
        super(message, cause);
    }
}
