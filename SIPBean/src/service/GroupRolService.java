package service;

import dao.IBasicDAO;
import dao.SimpleDAOImp;
import java.util.ArrayList;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import model.GroupRol;
import model.SystemTag;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * @author DEV Scout
 */
public class GroupRolService {

  public GroupRolService() {}

  private SystemTag findSystemTagById(Integer id) {
    SystemTagService service = new SystemTagService();
    SystemTag systemTag = service.findById(id);
    return systemTag;
  }

  private GroupRol getGroupRolLoaded(GroupRol data) {
    GroupRol groupRol = new GroupRol();
    groupRol.setName(data.getName().toUpperCase());
    groupRol.setFlagState(true);
    groupRol.setRegisterDate(new Date());
    return groupRol;
  }

  private GroupRol prepareGroupRolLoaded(GroupRol data) {
    SystemTag systemTag = this.findSystemTagById(data.getSystemTag().getId());
    GroupRol groupRol = this.getGroupRolLoaded(data);
    groupRol.setSystemTag(systemTag);
    return groupRol;
  }

  public void save(GroupRol data) {
    GroupRol groupRol = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      groupRol = this.prepareGroupRolLoaded(data);
      dao.save(groupRol);
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE SAVE: " + exc.getLocalizedMessage());
      throw exc;
    }
  }

  public void update(GroupRol data) {
    GroupRol groupRol = null;
    GroupRol groupRolUpdated = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      groupRol = this.findById(data.getId());
      if ((groupRol.getId() > 0) && (groupRol.isFlagState())) {
        groupRolUpdated = this.prepareGroupRolLoaded(data);
        groupRolUpdated.setId(groupRol.getId());
        dao.update(groupRolUpdated);
      } else {
        throw new EmptyStackException();
      }
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE UPDATE: " + exc.getLocalizedMessage());
      throw exc;
    }
  }

  public void delete(GroupRol data) {
    GroupRol groupRol = null;
    GroupRol groupRolDeleted = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      groupRol = this.findById(data.getId());
      if (groupRol.getId() > 0) {
        groupRolDeleted = new GroupRol();
        groupRolDeleted.setId(groupRol.getId());
        dao.delete(groupRolDeleted);
      } else {
        throw new EmptyStackException();
      }
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE DELETE: " + exc.getLocalizedMessage());
      throw exc;
    }
  }

  public GroupRol findById(Integer id) {
    GroupRol groupRol = null;
    Session session = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      groupRol = session.find(GroupRol.class, id);
      session.close();
      return groupRol;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return new GroupRol();
    }
  }

  public List<GroupRol> findAll() {
    Session session = null;
    Query<GroupRol> query = null;
    IBasicDAO dao = null;
    List<GroupRol> list = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      query = session.createQuery("SELECT objects FROM GroupRol AS objects", GroupRol.class);
      list = query.list();
      session.close();
      return list;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return new ArrayList<GroupRol>();
    }
  }

  public List<GroupRol> findAllByFlagState(boolean flagState) {
    Session session = null;
    Query<GroupRol> query = null;
    IBasicDAO dao = null;
    List<GroupRol> list = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      query = session.createQuery("SELECT objects FROM GroupRol AS objects WHERE (flagState = :flagState)", GroupRol.class);
      query.setParameter("flagState", flagState);
      list = query.list();
      session.close();
      return list;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return new ArrayList<GroupRol>();
    }
  }
}
