import com.humanbooster.exemple.bibliotheque.Bibliotheque;
import com.humanbooster.exemple.bibliotheque.Livre;

public class App {

    
    
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();

        Livre livre1 = new Livre("978-2-07-036822-8", "Le Petit Prince", "Antoine de Saint-Exupéry", 1943, true);
        Livre livre2 = new Livre("978-2-07-036823-5", "1984", "George Orwell", 1949, true);
        Livre livre3 = new Livre("978-2-07-036824-2", "Le Seigneur des Anneaux", "J.R.R. Tolkien", 1954, true);
    
        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);
        bibliotheque.ajouterLivre(livre3);

        bibliotheque.emprunterLivre(livre1.getIsbn());

        bibliotheque.getLivresDisponibles().forEach(System.out::println);
    

        System.out.println("------------EMPRUNTS------------");
        bibliotheque.getLivresEmpruntes().forEach(System.out::println);
        
        System.out.println("");
        System.out.println("");
        System.out.println("------------LIVRES APRES RENDU------------");

        bibliotheque.rendreLivre(livre1.getIsbn());
        bibliotheque.getLivresDisponibles().forEach(System.out::println);

    }


}