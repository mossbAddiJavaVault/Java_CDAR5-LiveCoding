package com.humanbooster.exemple.bibliotheque;

import java.util.Objects;

public class Livre {
    private String isbn;
    private String titre;
    private String auteur;
    private int anneePublication;
    private boolean disponible;

    public Livre(String isbn, String titre, String auteur, int anneePublication, boolean disponible) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.disponible = disponible;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitre() {
        return titre;
    }
    
    public boolean isDisponible() {
        return disponible;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        // si mon objet courant est égal return true
        if (this == o) {
            return true;
        }
        // si mon objet reçu est null ou ne correspond pas à ma classe Livre
        // je retourne false
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        // cast mon objet en livre et comparer en fonction de l'isbn
        Livre livre = (Livre) o;
        return Objects.equals(isbn, livre.isbn);
    }

    @Override
    public String toString() {
        return "Livre{" +
                    "isbn='" + isbn + '\'' +
                    ", titre='" + titre + '\'' +
                    ", auteur='" + auteur + '\'' +
                    ", anneePublication=" + anneePublication +
                    ", disponible=" + disponible +
                    '}';
    }

    

}
