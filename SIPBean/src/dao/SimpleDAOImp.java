package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.DBPersistence;

/**
 * @author DEV Scout
 */
public class SimpleDAOImp implements IBasicDAO {

  public SimpleDAOImp() {}

  @Override
  public void save(Object object) {
    Session session = null;
    Transaction transaction = null;
    try {
      session = DBPersistence.getConnection().openSession();
      transaction = session.beginTransaction();
      session.persist(object);
      transaction.commit();
      session.close();
    } catch (HibernateException exc) {
      System.err.println("ERROR DAO SAVE: " + exc.getMessage());
      throw exc;
    }
  }

  @Override
  public void update(Object object) {
    Session session = null;
    Transaction transaction = null;
    try {
      session = DBPersistence.getConnection().openSession();
      transaction = session.beginTransaction();
      session.update(object);
      transaction.commit();
      session.close();
    } catch (HibernateException exc) {
      System.err.println("ERROR DAO UPDATE: " + exc.getMessage());
      throw exc;
    }
  }

  @Override
  public void delete(Object object) {
    Session session = null;
    Transaction transaction = null;
    try {
      session = DBPersistence.getConnection().openSession();
      transaction = session.beginTransaction();
      session.delete(object);
      transaction.commit();
      session.close();
    } catch (HibernateException exc) {
      System.err.println("ERROR DAO DELETE: " + exc.getMessage());
      throw exc;
    }
  }

  @Override
  public Session getSession() {
    Session session = null;
    try {
      session = DBPersistence.getConnection().openSession();
      return session;
    } catch (HibernateException exc) {
      System.err.println("ERROR DAO OPEN: " + exc.getMessage());
      return null;
    }
  }
}
