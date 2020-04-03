package lesson101.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {
    String name() default "name";

    int age() default 1;

    String filePath() default "";
}
