package com.humanbooster.exemple;

public class TryCatchEtPropagation {


    /*
     * Cette fonction permet de diviser deux nombres
     * @param a: premier nombre qui se fera diviser
     * @param b: deuxième nombre qui divise le premier
     * @return: résultat de la division
     * @throws ArithmeticException si le diviseur est zéro
     */
    public static int diviser(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Tentative de division par zéro");
        }
        return a / b;
    }

}
