package com.humanbooster.exemple;

public class Triangle implements Calculable, Dessinable {
    private double base;
    private double hauteur;

    public Triangle(double base, double hauteur) {
        if (base < 0 || hauteur < 0 ) {
            throw new IllegalArgumentException("Les dimensions ne peuvent pas etre negatives");
        }
        this.base = base;
        this.hauteur = hauteur;
    }

    @Override
    public double calculerAire() {
        return (base * hauteur) / 2;
    }

    @Override
    public double calculerPerimetre() {
        double cote = Math.sqrt((base/2) * (base/2) + hauteur * hauteur);
        return base + 2 * cote;
    }

    @Override
    public void dessiner() {
        int h = (int) hauteur;
        int b = (int) base;
        for (int i = 0; i < h; i++) {
            // Parcourt les espaces à gauche


            for (int j = 0; j < (b/2) - (i * b/(2*h)); j++) {
                System.out.print(" ");
            }

            System.out.print("/");

            // Parcourt mes eespaces entre slashs
            for (int j = 0; j < 2 * (i * b/(2*h)); j++) {
                System.out.print(" ");
            }
            System.out.println("\\");

            

        }

        
        for (int i = 0; i < b; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    
    

        

}
