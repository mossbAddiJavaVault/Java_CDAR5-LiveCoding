package com.humanbooster.exemple;

public class Mage extends Personnage {
    public void bouleDeFeu() {
        System.out.println("boule de feeeu de feeeeeu");
    }

    public Mage(String nom, int sante) {
        super(nom, sante);
    }

    @Override
    public void marcher() {
        System.out.println("Je marche à la vitesse d'un mage");
    }
}
