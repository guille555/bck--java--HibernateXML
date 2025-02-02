package persistence;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author DEV Scout
 */
public class DBPersistence {

  private static SessionFactory factory = null;

  private DBPersistence() {}

  public static SessionFactory getConnection() {
    try {
      if (DBPersistence.factory == null) {
        DBPersistence.factory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
      }
      return DBPersistence.factory;
    } catch (HibernateException exc) {
      return null;
    }
  }

  public static void closeConnection() {
    try {
      if ((DBPersistence.factory != null) && (DBPersistence.factory.isOpen())) {
        DBPersistence.factory.close();
      }
    } catch (HibernateException exc) {
      System.err.println("ERROR HIBERNATE: " + exc.getMessage());
    }
  }

  public static void closeDB() {
    try {
      DriverManager.getConnection("jdbc:derby:memory:/app/test_db;user=dev;password=sprout;shutdown=true");
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: " + exc.getMessage());
    }
  }
}
