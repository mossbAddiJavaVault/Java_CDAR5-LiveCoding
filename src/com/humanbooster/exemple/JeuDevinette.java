package com.humanbooster.exemple;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JeuDevinette {
    /** Nombre à deviner */
    private final int nombreADeviner;

    /** stock des tentatives du joueur */
    private final int[] tentatives;



    /** nombre de tentatives en jeu */
    private int nombreTentatives;


    /** nombre max de tentatives */
    private static final int MAX_TENTATIVES = 10;

    private static final int MIN = 1;

    private static final int MAX = 100;

    public JeuDevinette() {
        Random random = new Random();
        // MIN=8 MAX=100
        // MAX - MIN + 1 = 100 - 8 + 1 = 93
        // l'opération nous donne un nombre entre 0 et 92 inclus
        // 0 + MIN = 0 + 8 = 8 
        this.nombreADeviner = random.nextInt(MAX - MIN + 1) + MIN;
        this.tentatives = new int[MAX_TENTATIVES];
        this.nombreTentatives = 0;
    }

    /**
     * Retourne le nombre à deviner
     * @return le nombre à deviner
     */
    public int getNombreADeviner() {
        return nombreADeviner;
    }

    
    /**
     * Retourne le nombre de tentatives effectuées
     * @return le nombre de tentatives
     */
    public int getNombreTentatives() {
        return nombreADeviner;
    }

    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        boolean trouve = false;


        System.out.println("Bienvenue dans le jeu de devinette");
        System.out.println("Je pense à un nombre entre " + MIN + " et " + MAX);
        while (!trouve && nombreTentatives < MAX_TENTATIVES) {
            System.out.print("Proposition : ");
            int proposition;
            try {
                
                proposition = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer un nombre valide");
                proposition = 0;
                scanner.next();
                continue;
            }
        
            // tentatives[0] = 56
            // tentatives[1] = 78
            // tentatives[2] = 92
            // {56, 78, 92}
            tentatives[nombreTentatives] = proposition;
            nombreTentatives++;

            if (proposition == nombreADeviner) {
                trouve = true;
                System.out.println("Bravo vous avez gagné");
            } else if (proposition < nombreADeviner) {
                System.out.println("Le nombre est plus grand");
            } else {
                System.out.println("Le nombre est plus petit");
            }
        }

        // if (!trouve) {
        //     System.out.println("Dommage!");
        // }
        if (nombreTentatives == MAX_TENTATIVES) {
            
        }

        afficherHistorique();

    }

    private void afficherHistorique() {
        System.out.println("Historique :");
        for (int i = 0; i < nombreTentatives; i++) {
            System.out.println("Tentatives : " + (i + 1) + " : " + tentatives[i]);
        }
    }
}
