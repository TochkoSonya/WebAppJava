package dao;

import model.*;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import java.util.List;


public class DirectorDao implements Dao<Director> {

    public DirectorDao() {
    }

    public void insert(Director director) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(director);
        tx1.commit();
        session.close();
    }

    public void delete(Director director) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(director);
        tx1.commit();
        session.close();
    }

    public void update(Director director) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(director);
        tx1.commit();
        session.close();
    }

    public List<Director> getAllDirectors() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Director> directors = session.createQuery("From Director").list();
        session.close();
        return directors;
    }

    public Director get(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Director.class, id);
    }

    public List<Director> getDirectorByName(String firstName, String lastName) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Director where firstName=:first and lastName=:last");
        query.setParameter("first", firstName);
        query.setParameter("last", lastName);
        List<Director> directors = query.list();
        if (directors.size() > 0) {
            session.close();
            return directors;
        } else {
            session.close();
            return null;
        }
    }
}
