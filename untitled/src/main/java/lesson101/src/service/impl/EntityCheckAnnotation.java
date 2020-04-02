package lesson101.src.service.impl;

import lesson101.src.annotation.Entity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntityCheckAnnotation implements CheckAnnotation {
    private Logger logger = LoggerFactory.getLogger(EntityCheckAnnotation.class);

    @Override
    public boolean check(Object object) {
        Class clazz = object.getClass();
        Entity anEntity = (Entity) clazz.getAnnotation(Entity.class);
        if (anEntity != null) {
            logger.info("Класс " + clazz.getName() + " помечен аннотацией " + Entity.class.getName());
            return true;

        }
        return false;
    }
}