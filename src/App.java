
import com.humanbooster.exemple.Cercle;
import com.humanbooster.exemple.Rectangle;
import com.humanbooster.exemple.Triangle;


public class App {

    
    // <ACESSIBILITE> <TYPE RETOUR> <NOM>(<PARAMETRES>) throws <ERRORTYPE> 
    public static void direBonjour() {
        System.out.println("bonjour");
    } 
    
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3.0, 8.0);
        rectangle.dessiner();
        System.out.println(rectangle.obtenirDescription());

        Cercle cercle = new Cercle(3.0);
        cercle.dessiner();
        
        Triangle triangle = new Triangle(5, 2);
        triangle.dessiner();
    }


}