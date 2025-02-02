package service;

import dao.IBasicDAO;
import dao.SimpleDAOImp;
import java.util.ArrayList;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import model.CompanyUser;
import model.GroupRol;
import model.SystemTag;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * @author DEV Scout
 */
public class CompanyUserService {

  public CompanyUserService() {}

  private SystemTag findSystemTagById(Integer id) {
    SystemTagService service = new SystemTagService();
    SystemTag systemTag = service.findById(id);
    return systemTag;
  }

  private GroupRol findGroupRolById(Integer id) {
    GroupRolService service = new GroupRolService();
    GroupRol groupRol = service.findById(id);
    return groupRol;
  }

  private CompanyUser getCompanyUser(CompanyUser data) {
    CompanyUser companyUser = new CompanyUser();
    companyUser.setUsername(data.getUsername());
    companyUser.setPassword(data.getPassword());
    companyUser.setFlagState(true);
    companyUser.setRegisterDate(new Date());
    return companyUser;
  }

  private CompanyUser prepareCompanyUser(CompanyUser data) {
    SystemTag systemTag = this.findSystemTagById(data.getSystemTag().getId());
    GroupRol groupRol = this.findGroupRolById(data.getGroupRol().getId());
    CompanyUser companyUser = this.getCompanyUser(data);
    companyUser.setSystemTag(systemTag);
    companyUser.setGroupRol(groupRol);
    return companyUser;
  }

  public void save(CompanyUser data) {
    CompanyUser companyUser = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      companyUser = this.prepareCompanyUser(data);
      dao.save(companyUser);
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE SAVE: " + exc.getMessage());
      throw exc;
    }
  }

  public void update(CompanyUser data) {
    CompanyUser companyUser = null;
    CompanyUser companyUserUpdated = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      companyUser = this.findById(data.getId());
      if ((companyUser.getId() > 0) && (companyUser.isFlagState())) {
        companyUserUpdated = this.prepareCompanyUser(data);
        companyUserUpdated.setId(data.getId());
        dao.update(companyUserUpdated);
      } else {
        throw new EmptyStackException();
      }
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE UPDATE: " + exc.getMessage());
      throw exc;
    }
  }

  public void delete(CompanyUser data) {
    CompanyUser companyUser = null;
    CompanyUser companyUserDeleted = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      companyUser = this.findById(data.getId());
      if (companyUser.getId() > 0) {
        companyUserDeleted = new CompanyUser();
        companyUserDeleted.setId(data.getId());
        dao.delete(companyUserDeleted);
      } else {
        throw new EmptyStackException();
      }
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE DELETE: " + exc.getMessage());
      throw exc;
    }
  }

  public CompanyUser findById(Long id) {
    CompanyUser companyUser = null;
    Session session = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      companyUser = session.find(CompanyUser.class, id);
      session.close();
      return companyUser;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return new CompanyUser();
    }
  }

  public List<CompanyUser> findAll() {
    Session session = null;
    Query<CompanyUser> query = null;
    IBasicDAO dao = null;
    List<CompanyUser> list = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      query = session.createQuery("SELECT objects FROM CompanyUser AS objects", CompanyUser.class);
      list = query.list();
      session.close();
      return list;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return new ArrayList<CompanyUser>();
    }
  }

  public List<CompanyUser> findAllByFlagState(boolean flagState) {
    Session session = null;
    Query<CompanyUser> query = null;
    IBasicDAO dao = null;
    List<CompanyUser> list = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      query = session.createQuery("SELECT objects FROM CompanyUser AS objects WHERE (flagState = :flagState)", CompanyUser.class);
      query.setParameter("flagState", flagState);
      list = query.list();
      session.close();
      return list;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return new ArrayList<CompanyUser>();
    }
  }
}
