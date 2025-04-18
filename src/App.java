import com.humanbooster.exemple.Voiture;

public class App {

    
    // <ACESSIBILITE> <TYPE RETOUR> <NOM>(<PARAMETRES>) throws <ERRORTYPE> 
    public static void direBonjour() {
        System.out.println("bonjour");
    } 
    
    public static void main(String[] args) {
        Voiture voiture = new Voiture("Tesla", "X", 20, 4);

        // System.out.println(voiture.getEstDemarree());
        voiture.demarrer();
        // System.out.println(voiture.getEstDemarree());
        // voiture.demarrer();
        // System.out.println(voiture.getEstDemarree());

        voiture.accelerer();
        System.out.println(voiture.getVitesseActuelle());
        voiture.accelerer();
        System.out.println(voiture.getVitesseActuelle());

        voiture.accelerer();
        System.out.println(voiture.getVitesseActuelle());
 
        voiture.accelerer();
    }
}