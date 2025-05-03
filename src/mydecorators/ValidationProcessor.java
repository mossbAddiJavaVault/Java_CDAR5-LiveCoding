package mydecorators;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidationProcessor {

    public static List<String> validate(Object object) {
        List<String> errors = new ArrayList<>();

        if (object == null) {
            errors.add("L'objet à valider ne peut pas être null");
            return errors;
        }

        // Itérer sur tous les attributs de l'objet et lancer validateField
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                validateField(object, field, errors);
                
            } catch (IllegalAccessException e) {
                errors.add("Erreur d'accès au champ : " + field.getName());
            }
            
        }
        return errors;
    }

    private static void validateField(Object object, Field field, List<String> errors) throws IllegalAccessException {
        Object value = field.get(object);
        // Validation @NotNull
        if (field.isAnnotationPresent(NotNull.class)) {
            NotNull annotation = field.getAnnotation(NotNull.class);
            if (value == null) {
                errors.add(annotation.message());
            }
        }

        if (field.isAnnotationPresent(Size.class)) {
            Size annotation = field.getAnnotation(Size.class);
            if (value instanceof String) {
                String strValue = (String) value;
                int length = strValue.length();
                if (length < annotation.min() || length > annotation.max()) {
                    String message = annotation.message()
                        .replace("{min}", String.valueOf(annotation.min()))
                        .replace("{max}", String.valueOf(annotation.max()));
                    errors.add(message);
                }
            }
        }

    }
}
