package com.util;

import com.exceptions.DonneesInvalidesException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidationUtil {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void validerTitre(String titre) throws DonneesInvalidesException {
        if (titre == null || titre.trim().isEmpty()  ) {
            throw new DonneesInvalidesException("Le titre ne peut pas etre null ou vide");
        }
    }

    public static void validerAuteur(String auteur) throws DonneesInvalidesException {
        if (auteur == null || auteur.trim().isEmpty()  ) {
            throw new DonneesInvalidesException("L'auteur ne peut pas etre null ou vide");
        }
    }

    public static void validerIsbn(String isbn) throws DonneesInvalidesException {
        if (isbn == null || isbn.trim().isEmpty()  ) {
            throw new DonneesInvalidesException("L'isbn ne peut pas etre null ou vide");
        }
    }



    public static void validerDateEmprunt(String dateStr) throws DonneesInvalidesException {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            throw new DonneesInvalidesException("La date d'emprunt ne peut pas etre null ou vide");
        }

        try {
            LocalDate date = LocalDate.parse(dateStr, DATE_FORMATTER);
            if (date.isAfter(LocalDate.now())) {
                throw new DonneesInvalidesException("La date d'emprunt ne peut pas postérieure au jour d'emprunt");
            }
            
        } catch (DateTimeParseException e) {
            throw new DonneesInvalidesException("Format de date invalide", e);
        }
    }
}
