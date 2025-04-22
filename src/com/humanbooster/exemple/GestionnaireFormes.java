package com.humanbooster.exemple;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireFormes {
    private List<Calculable> formesCalculables = new ArrayList<>();
    private List<Dessinable> formesDessinables = new ArrayList<>();

    // public void ajouterForme(Calculable calculable, Dessinable dessinable) {
    //     formesCalculables.add(calculable);
    //     formesDessinables.add(dessinable);
    // }



    public void ajouterForme(Object forme) throws IllegalArgumentException {
        
        if (!(forme instanceof Calculable) && !(forme instanceof Dessinable) ) {
            throw new IllegalArgumentException();
        }
        if (forme instanceof Calculable) {
           formesCalculables.add((Calculable)forme);
        } 
        if (forme instanceof Dessinable) {
            formesDessinables.add((Dessinable)forme);             
        } 

    }

    public void dessinerTout() {
        for (Dessinable dessinable : formesDessinables) {
            dessinable.dessiner();
        }
    }



    


    public void afficherAirePerimetre() {
        // for (Calculable calculable : formesCalculables) {
        //     System.out.println("Aire : " + calculable.calculerAire() + "Perimetre : " + calculable.calculerPerimetre());            
        // }
        formesDessinables.forEach(forme -> {
            forme.dessiner();
        });
    }

    public double calculerPerimetreTotal() {
        return formesCalculables.stream()
                              .mapToDouble(Calculable::calculerPerimetre)
                              .sum();
    }




    public double calculerAireTotale() {
        return formesCalculables.stream()
                            .mapToDouble(Calculable::calculerAire)
                            .sum();
    }


    public int getNombreFormesCalculables() {
        return formesCalculables.size();
    }

}


