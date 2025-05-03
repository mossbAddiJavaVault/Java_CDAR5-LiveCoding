package com.util;

import com.exceptions.BibliothequeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BibliothequeLogger {
    private static final DateTimeFormatter LOG_FORMATTER = DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss");

    public static void logError(BibliothequeException e) {
        StringBuilder log = new StringBuilder();
        log.append("\n=== ERREUR BIBLIOTHÈQUE ===\n");
        log.append("Date : ").append(LocalDateTime.now().format(LOG_FORMATTER)).append("\n");
        log.append("Type d'erreur : ").append(e.getClass().getSimpleName()).append("\n");
        log.append("Message : ").append(e.getMessage()).append("\n");
    
        if (e.getCause() != null) {
                        log.append("\nCause de l'erreur :\n");
                        log.append("Type : " ).append(e.getCause().getClass()).append("\n");
        }
    }
}
