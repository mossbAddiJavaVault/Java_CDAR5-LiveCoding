package com.exceptions;

public class DonneesInvalidesException extends BibliothequeException {
    public DonneesInvalidesException(String message) {
        super(message);
    }

    public DonneesInvalidesException(String message, Throwable cause) {
        super(message, cause);
    }


}
