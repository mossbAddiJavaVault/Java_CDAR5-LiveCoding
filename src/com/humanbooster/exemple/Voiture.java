package com.humanbooster.exemple;

public class Voiture extends Vehicule {
    private int nombrePortes;
    private boolean estDemarree;
    private int vitesseActuelle;

    public Voiture(String marque, String modele, int vitesseMax, int nombrePortes) {
        super(marque, modele, vitesseMax);
        // new Vehicule(marque, modele, vitesse max)
        this.nombrePortes = nombrePortes;
    }

    public boolean getEstDemarree() {
        return estDemarree;
    }

    public int getVitesseActuelle() {
        return vitesseActuelle;
    }

    @Override
    public void demarrer() {
        if (!estDemarree) {
            estDemarree = true;
            System.out.println("La voiture démarre...");
        } else {
            System.out.println("La voiture est démarrée");
        }
    }

    @Override
    public void accelerer() {
        // if (estDemarree && vitesseActuelle < vitesseMax) {
        //     vitesseActuelle += 10;
        //     System.out.println("La voiture accélère");
        // } else if (vitesseActuelle >= vitesseMax) {

        //     System.out.println("La vitesse est déjà atteinte");
        // } else {
        //     System.out.println("La voiture n'est pas démarrée");
        // }



        // si la voiture n'est pas démarrée elle n'accélère pas
        if (!estDemarree) {
            System.out.println("La voiture n'est pas démarrée");
            return ; 
        }
        // si la voiture a atteint sa vitesse max elle n'accélère pas 
        if (vitesseActuelle >= vitesseMax) {
            System.out.println("La voiture a atteint sa vitesse max");
            return;
        }

        vitesseActuelle += 10;
        System.out.println("La voiture accélère");
    }

    @Override
    void freiner() {
        // si la voiture a une vitesse de 0 ou moins, je suis déjà à l'arrêt
        if (vitesseActuelle <= 0) {
            System.out.println("La voiture est déjà à l'arrêt");
        } else {
            vitesseActuelle--;
            System.out.println("la voiture freine");
        }
    }

    @Override
    public void afficherInfo() {
        // TODO Auto-generated method stub
        super.afficherInfo();
        System.out.println("Nombre de portes : " + nombrePortes);
    }


    @Override
    String getTypeVehicule() {
        
        return "Voiture";
    }
}
