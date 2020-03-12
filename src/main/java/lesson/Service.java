package lesson;


import lesson4.EntityCreationException;

import java.util.List;


public interface Service<T> {
     T findUser(long id) throws EntityCreationException;
     List<T> findAll();
     void save(T t);
     void saveAll(List<T> list);
}

