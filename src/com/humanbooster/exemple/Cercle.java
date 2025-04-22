package com.humanbooster.exemple;

public class Cercle implements Calculable, Dessinable {
    private double rayon;
    private static final double PI = Math.PI;


    public Cercle(double rayon) {
        if (rayon < 0) {
            throw new IllegalArgumentException("Le rayon ne peut pas être négatif");
        }
        this.rayon = rayon;
    }

    @Override
    public double calculerAire() {
        return PI * rayon * rayon;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * PI * rayon;
    }

    @Override
    public void dessiner() {
        int r = (int) rayon;
        int diametre = 2 * r;
        
        for (int i = 0; i <= diametre; i++) {
            for (int j = 0; j <= diametre; j++) {
                double di = i - r;
                double dj = j - r;
                
                // Vérifie si le cercle interne tracé est arrivé à son maximum
                if ((di * di) + (dj * dj) <= r * r ) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.err.println("");
        }
    }

    
}
