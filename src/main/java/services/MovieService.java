package services;

import dao.MovieDao;
import model.*;

import java.util.List;

public class MovieService implements Service<Movie> {

    private final MovieDao movieDao;

    public MovieService() {
        movieDao = new MovieDao();
    }

    public void insert(Movie movie) {
        movieDao.insert(movie);
    }

    public void delete(Movie movie) {
        movieDao.delete(movie);
    }

    public void update(Movie movie) {
        movieDao.update(movie);
    }

    public List<Movie> listAllObjects() {
        return movieDao.listAllObjects();
    }

    public Movie get(int id) {
        return movieDao.get(id);
    }
}
