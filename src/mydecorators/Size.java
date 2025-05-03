package mydecorators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Size {

    int min() default 0;

    int max() default 50;
    String message() default "La taille doit être comprise entre {min} et {max} caractères";

}
