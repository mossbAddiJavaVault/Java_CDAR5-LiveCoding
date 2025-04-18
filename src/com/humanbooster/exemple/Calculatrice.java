package com.humanbooster.exemple;

/**
 * Classe Calculatrice permettant d'additioner, multiplier, soustraire, diviser
 * @author Mostapha
 * @version 1.0  
 */
public class Calculatrice {

    /**
     * Effectue l'addition de deux nombres décimaux
     * @param a Premier nombre
     * @param b Deuxième nombre
     * @return La somme des deux nombres
     */
    public double additionner(double a, double b) {
        return a + b;
    }


    /**
     * Effectue la soustraction de deux nombres décimaux
     * @param a Premier nombre
     * @param b Deuxième nombre
     * @return La différence des deux nombres
     */
    public double soustraire(double a, double b) {
        return a - b;
    }

    /**
     * Effectue la multiplication de deux nombres décimaux
     * @param a Premier nombre
     * @param b Deuxième nombre
     * @return Le produit des deux nombres
     */
    public double multiplier(double a, double b) {
        return a * b;
    }


    /**
     * Effectue la division de deux nombres décimaux
     * @param a Dividende
     * @param b Diviseur
     * @return Le quotient de la division
     * @throws ArithmeticException si le diviseur est zéro
     */
    public double diviser(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro");
        }
        return a / b; 
    }
}