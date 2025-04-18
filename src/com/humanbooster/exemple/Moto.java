package com.humanbooster.exemple;

public class Moto extends Vehicule {
    private String typeMoto;
    private boolean estDemarree;
    private int vitesseActuelle;


    public Moto(String marque, String modele, int vitesseMax, String typeMoto) {
        super(marque, modele, vitesseMax);
        if (typeMoto == null || typeMoto.trim().isEmpty()) {
            throw new IllegalArgumentException("Le type de moto ne peut pas être vide");
        }
        this.typeMoto = typeMoto;
        this.estDemarree = false;
        this.vitesseActuelle = 0;
    }

    @Override
    public void demarrer() {
        if (!estDemarree) {
            estDemarree = true;
            System.out.println("La moto démarre...");
        } else {
            System.out.println("La moto est déjà démarrée");
        }
    }

    @Override
    public void accelerer() {
        if (!estDemarree) {
            System.out.println("La moto doit être démarrée pour accélérer");
            return;
        }
        
        if (vitesseActuelle < vitesseMax) {
            vitesseActuelle += 15;
            System.out.println("La moto accélère. Vitesse actuelle : " + vitesseActuelle + " km/h");
        } else {
            System.out.println("La moto a atteint sa vitesse maximale");
        }
    }

    @Override
    public void afficherInfo() {
        super.afficherInfo();
        System.out.println("Type de moto : " + typeMoto);
        System.out.println("État : " + (estDemarree ? "Démarrée" : "Arrêtée"));
        System.out.println("Vitesse actuelle : " + (vitesseActuelle < 20 ? vitesseActuelle + "lent" : vitesseActuelle + "Rapide") + " km/h");
    }

    
}
