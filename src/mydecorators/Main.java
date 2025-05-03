package mydecorators;

import java.util.List;

class Utilisateur {
    @NotNull
    @Size(min = 5, max = 10)
    private String nom;

    public Utilisateur(String nom) {
        this.nom = nom;
    }

    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}

public class Main {

    public static void main(String[] args) {
        Utilisateur utilisateurValide = new Utilisateur("Jeaahhdheent");
        List<String> erreurs1 = ValidationProcessor.validate(utilisateurValide);
        erreurs1.forEach(System.out::println);    
    
        Utilisateur utilisateurNull = new Utilisateur(null);
        List<String> erreurs2 = ValidationProcessor.validate(utilisateurNull);
        erreurs2.forEach(System.out::println);    
        
    }

}



/*
 * 
 * [requete json entrante] 
 *       -> [devient un objet de l'interface du modele cible]
 *             
 *      object.save() {  -> [lance la méthode de validation]
 *                      -> [Entrer l'objet dans une ligne de la table de sa BDD] }
 */