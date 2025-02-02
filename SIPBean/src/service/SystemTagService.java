package service;

import dao.IBasicDAO;
import dao.SimpleDAOImp;
import java.util.ArrayList;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import model.SystemTag;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * @author DEV Scout
 */
public class SystemTagService {

  public SystemTagService() {}

  private SystemTag returnSystemTagLoaded(SystemTag data) {
    SystemTag systemTag = new SystemTag();
    systemTag.setName(data.getName().toUpperCase());
    systemTag.setFlagState(true);
    systemTag.setRegisterDate(new Date());
    return systemTag;
  }

  public void save(SystemTag data) {
    SystemTag systemTag = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      systemTag = this.returnSystemTagLoaded(data);
      dao.save(systemTag);
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE SAVE: " + exc.getLocalizedMessage());
      throw exc;
    }
  }

  public void update(SystemTag data) {
    IBasicDAO dao = null;
    SystemTag systemTag = null;
    SystemTag systemTagUpdated = null;
    try {
      dao = new SimpleDAOImp();
      systemTag = this.findById(data.getId());
      if ((systemTag.getId() > 0) && (systemTag.isFlagState())){
        systemTagUpdated = this.returnSystemTagLoaded(data);
        systemTagUpdated.setId(systemTag.getId());
        dao.update(systemTagUpdated);
      } else {
        throw new EmptyStackException();
      }
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE UPDATE: " + exc.getLocalizedMessage());
      throw exc;
    }
  }

  public void delete(SystemTag data) {
    IBasicDAO dao = null;
    SystemTag systemTag = null;
    SystemTag systemTagDeleted = null;
    try {
      dao = new SimpleDAOImp();
      systemTag = this.findById(data.getId());
      if (systemTag.getId() > 0) {
        systemTagDeleted = new SystemTag();
        systemTagDeleted.setId(systemTag.getId());
        dao.delete(systemTagDeleted);
      } else {
        throw new EmptyStackException();
      }
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE UPDATE: " + exc.getLocalizedMessage());
      throw exc;
    }
  }

  public SystemTag findById(Integer id) {
    SystemTag systemTag = null;
    Session session = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      systemTag = session.find(SystemTag.class, id);
      session.close();
      return systemTag;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return null;
    }
  }

  public List<SystemTag> findAll() {
    Session session = null;
    Query<SystemTag> query = null;
    IBasicDAO dao = null;
    List<SystemTag> list = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      query = session.createQuery("SELECT objects FROM SystemTag AS objects", SystemTag.class);
      list = query.list();
      session.close();
      return list;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return new ArrayList<SystemTag>();
    }
  }

  public List<SystemTag> findAllByFlagState(boolean flagState) {
    Session session = null;
    Query<SystemTag> query = null;
    IBasicDAO dao = null;
    List<SystemTag> list = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      query = session.createQuery("SELECT objects FROM SystemTag AS objects WHERE (objects.flagState = :flagState)", SystemTag.class);
      query.setParameter("flagState", flagState);
      list = query.list();
      session.close();
      return list;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return new ArrayList<SystemTag>();
    }
  }
}
