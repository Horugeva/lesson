package lesson2test;

import java.util.List;

public interface Repository<T> {
     T findUser(long id);
     List<T> findAll();
     void save(T t);
     void saveAll(List<T> list);
}


