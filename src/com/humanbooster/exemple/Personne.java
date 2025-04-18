package com.humanbooster.exemple;

public class Personne {
    private String nom;
    private String prenom;
    private int age;
    private static int nombrePersonnes = 0;

    public Personne() {
        this.nom = "";
        this.prenom = "";
        this.age = 0;
        nombrePersonnes++;
    }


    // Personne mapersonne = new Personne("blabla",  "   ", 0);

    public Personne(String nom, String prenom, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("L'âge doit être un entier positif");
        }
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
        if (prenom == null || prenom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le prenom ne peut pas être vide");
        }

        this.nom = nom.trim();
        this.prenom = prenom.trim();
        this.age = age;
        nombrePersonnes++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
        this.nom = nom.trim();

    }

    public String getPrenom() {
        return prenom;
    }


    public void setPrenom(String prenom) {
        if (prenom == null || prenom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le prenom ne peut pas être vide");
        }
        this.prenom = prenom.trim();

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("L'âge doit être un entier positif");
        }
        this.age = age;
    } 



    public void afficherPersonne() {
        System.err.println("Nom : " + this.nom + "Prenom : " + this.prenom + "Age : " + this.age);
    }

    @Override
    public String toString() {
        return "Nom : " + this.nom + "Prenom : " + this.prenom + "Age : " + this.age;
    }

    public int getNombrePersonnes() {
        return nombrePersonnes;
    }

    public boolean estIdentique(Personne autre) {
        if (autre == null) {
            return false;
        }
        return this.nom.equals(autre.nom) && this.prenom.equals(autre.prenom) && this.age == autre.age;
    }




    // System.out.println(testpersonne)

    // private static void checker() {

    // }

    // private static void checker(String nom) {

    // }

}
