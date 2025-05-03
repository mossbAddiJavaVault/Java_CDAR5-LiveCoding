package com.exceptions;

public class LivreDejaEmprunteException extends BibliothequeException {

    public LivreDejaEmprunteException(String message) {
        super(message);
    }

    public LivreDejaEmprunteException(String message, Throwable cause) {
        super(message, cause);
    }



}
