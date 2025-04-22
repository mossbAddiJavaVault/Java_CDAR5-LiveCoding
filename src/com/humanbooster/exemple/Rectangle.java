package com.humanbooster.exemple;

public class Rectangle implements Calculable, Dessinable {
    private double longueur;
    private double largeur;

    public Rectangle(double longueur, double largeur) {
        if (longueur < 0 || largeur < 0) {
            throw new IllegalArgumentException("Les dimensions ne peuvent pas être négatives");
        }
        this.longueur = longueur;
        this.largeur = largeur;
    }

    @Override
    public double calculerAire() {
        return longueur * largeur;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * (longueur + largeur);
    }


    @Override
    public void dessiner() {
        int hauteur = Math.min((int) Math.ceil(largeur), 20);
        int largeurAffichage = Math.min((int) Math.ceil(longueur), 40);

        System.out.print("+");
        
        for (int i = 0; i < largeurAffichage; i++) {
            System.out.print("-");
            
        }
        
        System.out.println("+");

        for (int i = 0; i < hauteur; i++) {
            System.out.print("|");
            for (int j = 0; j < largeurAffichage; j++) {
                System.out.print(" ");
                
            }
            
            System.out.println("|");
            
        }

        System.out.print("+");
        
        for (int i = 0; i < largeurAffichage; i++) {
            System.out.print("-");
            
        }
        
        System.out.println("+");
    }

    @Override
    public String obtenirDescription() {
        return String.format("Longueur: %.2f Largeur: %.2f (Aire: %.2f, Perimetre: %.2f)", longueur, largeur, calculerAire(), calculerPerimetre());
    }


    // " je suis {nom} et j'ai {age} ans"



}


