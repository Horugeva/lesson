package lesson101.impl;

import lesson101.Data;
import lesson101.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class ValueServiceAnnotation {
    private Logger logger = LoggerFactory.getLogger(ValueServiceAnnotation.class);
    private FileService fileService = new FileService();

    public boolean check(Object object) {
        Class clazz = object.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (!field.isAnnotationPresent(Value.class)) {
                logger.info("Поля класса " + clazz.getName() + " не помечены аннотациями");
                return false;
            }
        }
        return true;
    }

    public boolean anyMatch(Object object) {
        Class clazz = object.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Value.class)) {
                logger.info(String.valueOf(field.isAnnotationPresent(Value.class)));
                return true;
            }
        }
        return false;
    }

    public void initParams(Object object) throws IllegalAccessException, IOException {
        Class clazz = object.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            Value value = field.getAnnotation(Value.class);
            if (!value.filePath().equals("")) {
                List<Data> data = fileService.getDataFromTxtFile(value.filePath());
                setDataFromFile(data.get(0), field, object);
            } else {
                setDataFromAnnotation(field, value, object);
            }
        }
    }

    private void setDataFromAnnotation(Field field, Value value, Object object) throws IllegalAccessException {
        if (field.getName().equals("name")) {
            field.setAccessible(true);
            field.set(object, value.name());
        }
        if (field.getName().equals("age")) {
            field.setAccessible(true);
            field.setInt(object, value.age());
        }
    }

    private void setDataFromFile(Data data, Field field, Object object) throws IllegalAccessException {
        if (field.getName().equals("name")) {
            field.setAccessible(true);
            field.set(object, data.getName());
        }
        if (field.getName().equals("age")) {
            field.setAccessible(true);
            field.setInt(object, data.getAge());
        }
    }
}