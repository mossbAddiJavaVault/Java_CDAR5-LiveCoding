package com.humanbooster.exemple.bibliotheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class Bibliotheque {
    private List<Livre> livres;
    private Map<String, LocalDate> emprunts;

    public Bibliotheque() {
        this.livres = new ArrayList<>();
        this.emprunts = new HashMap<>(); 
    }


    
    


    public boolean ajouterLivre(Livre livre) {
        if (livre == null || livres.contains(livre)) {
            return false;
        }
        return livres.add(livre);
    }

    public boolean supprimerLivre(String isbn) {
        Livre livre  = rechercherLivre(isbn);
        if (livre == null) {
            return false;
        }
        return livres.remove(livre);
    }

    // public boolean supprimerLivre(String isbn) {
    //     return livres.removeIf(l -> l.getIsbn().equals(isbn));
    // }

    public Livre rechercherLivre(String isbn) {
        return livres.stream()
        .filter(l -> l.getIsbn().equals(isbn))
        .findFirst()
        .orElse(null);
    }

    public boolean emprunterLivre(String isbn) {
        Livre livre = rechercherLivre(isbn);
        if (livre == null || !livre.isDisponible() || emprunts.containsKey(isbn)) {
            return false;
        }
        livre.setDisponible(false);
        emprunts.put(isbn, LocalDate.now());
        return true;
    }

    public boolean rendreLivre(String isbn) {
        
        // verifier qu'il s'agit bien d'un livre emprunté
        if (!emprunts.containsKey(isbn)) {
            return false;
        }

        // Récupérer le livre et le retirer de la liste d'emprunts
        Livre livre = rechercherLivre(isbn);
        if (livre == null) {
            return false;
        }
        livre.setDisponible(true);
        emprunts.remove(isbn);
        return true;
    }

    public List<Livre> getLivresDisponibles() {
        return livres.stream()
                .filter(Livre::isDisponible)
                .collect(Collectors.toList());
    }


    public List<Livre> getLivresEmpruntes() {
        return livres.stream()
                .filter(l -> !l.isDisponible())
                .collect(Collectors.toList());
    }


}
