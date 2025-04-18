package com.humanbooster.exemple;

public abstract class Personnage {
    private String nom;
    private int sante;

    public abstract void marcher();

    public Personnage(String nom, int sante) {
        this.nom = nom;
        this.sante = sante;
    }

}
