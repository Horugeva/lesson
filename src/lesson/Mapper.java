package lesson;

public interface Mapper<T,E> {
    void mapAToB(T t, E e);
    void mapBToA(T t, E e);

}
