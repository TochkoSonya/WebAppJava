package Services;

import Model.Movie;

import java.sql.SQLException;
import java.util.List;

public interface Service<T> {
    void insert(T t);
    void delete(T t);
    void update(T t);
    T get(int id);
}
