package com.humanbooster.exemple;

public abstract class Vehicule {
    protected String marque;
    protected String modele;
    protected int vitesseMax;

    public Vehicule(String marque, String modele, int vitesseMax) {
        if (marque == null || marque.trim().isEmpty() ) {
            throw new IllegalArgumentException("Erreur : l'argument <marque> ne peut pas être nul ou vide");            
        }

        if (modele == null || modele.trim().isEmpty() ) {
            throw new IllegalArgumentException("Erreur : l'argument <modele> ne peut pas être nul ou vide");            
        }
        if (vitesseMax < 0) {
            throw new IllegalArgumentException("Erreur : l'argument <marque> ne peut pas être nul ou vide");            
        }
        this.marque = marque;
        this.modele = modele;
        this.vitesseMax = vitesseMax;
    }


    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        if (marque == null || marque.trim().isEmpty() ) {
            throw new IllegalArgumentException("Erreur : l'argument <marque> ne peut pas être nul ou vide");            
        }
        this.marque = marque;
    }

    public String getModele() {
        if (modele == null || modele.trim().isEmpty() ) {
            throw new IllegalArgumentException("Erreur : l'argument <modele> ne peut pas être nul ou vide");            
        }
        return modele;
    }

    public void setModele(String modele) {
        if (vitesseMax < 0) {
            throw new IllegalArgumentException("Erreur : l'argument <marque> ne peut pas être nul ou vide");            
        }
        this.modele = modele;
    }

    public int getVitesseMax() {

        return vitesseMax;
    }

    public void setVitesseMax(int vitesseMax) {
        if (vitesseMax <= 0) {
            throw new IllegalArgumentException("Erreur : l'argument <marque> ne peut pas être nul ou vide");            
        }
        this.vitesseMax = vitesseMax;
    }

    abstract void demarrer();
    abstract void accelerer();
    abstract void freiner();
    abstract String getTypeVehicule();

    public void afficherInfo() {
        System.out.println("Marque : " + marque);
        System.out.println("Modèle : " + modele);
        System.out.println("Vitesse Max : " + vitesseMax);
    }
    
}
