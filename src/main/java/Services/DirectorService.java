package Services;

import Dao.DirectorDao;
import Model.Director;
import Model.Movie;

import java.util.List;

public class DirectorService implements Service<Director>{
    private DirectorDao directorDao;

    public DirectorService(){
        directorDao=new DirectorDao();
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

    public List<Director> getAllDirectors(){
        return directorDao.getAllDirectors();
    }

    public Director get(int id) {
        return directorDao.get(id);
    }

    public List<Director> getDirectorByName(String firstName, String lastName){
        return directorDao.getDirectorByName(firstName,lastName);
    }

}
