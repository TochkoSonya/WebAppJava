package Dao;

import Model.*;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Utils.HibernateSessionFactoryUtil;

public class MovieDao implements Dao<Movie>{

    public MovieDao(){  }

    public void insert(Movie movie) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.save(movie);
        session.saveOrUpdate(movie.getDirector());
        tx1.commit();
        session.close();

    }

    public void delete(Movie movie){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1=session.beginTransaction();
        session.delete(movie);
        tx1.commit();
        session.close();

    }

    public void update(Movie movie) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(movie);
        tx1.commit();
        session.close();
    }

    public List<Movie> listAllObjects() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Movie> movies=session.createQuery("From Movie").list();
        session.close();
        return movies;

    }

    public Movie get(int id) {
        Session session=HibernateSessionFactoryUtil.getSessionFactory()
                .openSession();
        Movie movie=session.get(Movie.class, id);
        session.close();
        return movie;

    }

}
