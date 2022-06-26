package dao;

public interface Dao<T> {

    void insert(T t);

    void delete(T t);

    void update(T t);

    T get(int id);
}
