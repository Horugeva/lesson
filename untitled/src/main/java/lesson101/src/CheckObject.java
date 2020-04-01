package lesson101.src;

import lesson101.src.service.impl.EntityCheckAnnotation;
import lesson101.src.service.impl.ValueServiceAnnotation;

import java.io.IOException;


public class CheckObject {
    public void check(Object object) throws IllegalAccessException, IOException {
        EntityCheckAnnotation entityCheckAnnotation = new EntityCheckAnnotation();
        ValueServiceAnnotation valueCheckAnnotation = new ValueServiceAnnotation();
        if (entityCheckAnnotation.check(object)) {
            if (!valueCheckAnnotation.check(object)) {
                throw new NoValueAnnotationException("NoValueAnnotationException");
            } else {
                valueCheckAnnotation.initParams(object);
            }

        } else if (!entityCheckAnnotation.check(object)) {
            if (valueCheckAnnotation.anyMatch(object)) {
                throw new IllegalStateException("IllegalStateException");
            }
        }
    }
}
