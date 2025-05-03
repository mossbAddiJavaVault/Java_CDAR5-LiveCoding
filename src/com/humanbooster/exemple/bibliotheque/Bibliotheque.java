package com.humanbooster.exemple.bibliotheque;

import com.exceptions.DonneesInvalidesException;
import com.exceptions.LivreDejaEmprunteException;
import com.exceptions.LivreDejaEnregistreException;
import com.exceptions.LivreNonDisponibleException;
import com.util.ValidationUtil;
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


    
    


    public void ajouterLivre(Livre livre) throws DonneesInvalidesException, LivreDejaEnregistreException {
        if (livre == null ) {
            throw new DonneesInvalidesException("Le livre donné ne peut pas être Null");
        }

        ValidationUtil.validerAuteur(livre.getAuteur());
        ValidationUtil.validerIsbn(livre.getIsbn());
        ValidationUtil.validerTitre(livre.getTitre());
        


        if (livres.contains(livre)) {
            throw new LivreDejaEnregistreException("Le livre a déjà été enregistré. Si nécessaire, veuillez augmenter le stock.");
        }
        livres.add(livre);
    }

    public void supprimerLivre(String isbn) throws DonneesInvalidesException, LivreNonDisponibleException {
        ValidationUtil.validerIsbn(isbn);
        Livre livre  = rechercherLivre(isbn);
        if (livre == null) {
            throw new LivreNonDisponibleException("Aucun livre trouvé avec l'ISBN : " + isbn);
        }

        if (emprunts.containsKey(isbn)) {
            throw new LivreNonDisponibleException("Le livre est actuellement emprunté et ne peut donc pas être supprimé");
        }
        livres.remove(livre);
    }


    public Livre rechercherLivre(String isbn) throws DonneesInvalidesException {
        ValidationUtil.validerIsbn(isbn);
        return livres.stream()
        .filter(l -> l.getIsbn().equals(isbn))
        .findFirst()
        .orElse(null);
    }

    public void emprunterLivre(String isbn) throws DonneesInvalidesException, LivreNonDisponibleException, LivreDejaEmprunteException {
        ValidationUtil.validerIsbn(isbn);

        Livre livre = rechercherLivre(isbn);
        if (livre == null ) {
            throw new LivreNonDisponibleException("Aucun livre trouvé avec l'ISBN : " + isbn);
        }
        if ( !livre.isDisponible()) {
            throw new LivreNonDisponibleException("Le livre n'est pas disponible");

        }
        if (emprunts.containsKey(isbn)) {
            throw new LivreDejaEmprunteException("le livre est déjà emprunté");
        }
        livre.setDisponible(false);
        emprunts.put(isbn, LocalDate.now());
    }

    public void rendreLivre(String isbn) throws DonneesInvalidesException, LivreNonDisponibleException {
        ValidationUtil.validerIsbn(isbn);
        
        // verifier qu'il s'agit bien d'un livre emprunté
        if (!emprunts.containsKey(isbn)) {
            throw new LivreNonDisponibleException("le livre n'était pas emprunté");
        }

        // Récupérer le livre et le retirer de la liste d'emprunts
        Livre livre = rechercherLivre(isbn);
        if (livre == null) {
            throw new LivreNonDisponibleException("Aucun livre trouvé avec l'ISBN : " + isbn)
        }
        livre.setDisponible(true);
        emprunts.remove(isbn);
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
