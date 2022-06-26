package services;

import dao.DirectorDao;
import model.Director;

import java.util.List;

public class DirectorService implements Service<Director> {

    private final DirectorDao directorDao;

    public DirectorService() {
        directorDao = new DirectorDao();
    }

    public void insert(Director director) {
        directorDao.insert(director);
    }

    public void delete(Director director) {
        directorDao.delete(director);
    }

    public void update(Director director) {
        directorDao.update(director);
    }

    public List<Director> getAllDirectors() {
        return directorDao.getAllDirectors();
    }

    public Director get(int id) {
        return directorDao.get(id);
    }

    public List<Director> getDirectorByName(String firstName, String lastName) {
        return directorDao.getDirectorByName(firstName, lastName);
    }
}
