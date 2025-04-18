package com.humanbooster.exemple;

public class Guerrier extends Personnage {
    private int armure;

    public void provoquer() {
        System.out.println("je provoque baah baah baah");
    }

    public Guerrier(String nom, int sante, int armure) {
        super(nom, sante);
        this.armure = armure;
    }

    @Override
    public void marcher() {
        System.out.println("Je marche à la vitesse d'un guerrier");
    }
}
