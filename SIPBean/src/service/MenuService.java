package service;

import dao.IBasicDAO;
import dao.SimpleDAOImp;
import java.util.ArrayList;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import model.GroupRol;
import model.Menu;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * @author DEV Scout
 */
public class MenuService {

  public MenuService() {}

  private GroupRol findGroupRolById(Integer id) {
    GroupRolService service = new GroupRolService();
    GroupRol groupRol = service.findById(id);
    return groupRol;
  }

  private Menu getMenuLoaded(Menu data) {
    Menu menu = new Menu();
    menu.setName(data.getName().toUpperCase());
    menu.setFlagState(true);
    menu.setRegisterDate(new Date());
    return menu;
  }

  private Menu prepareMenuLoaded(Menu data) {
    GroupRol groupRol = this.findGroupRolById(data.getGroupRol().getId());
    Menu menu = this.getMenuLoaded(data);
    menu.setGroupRol(groupRol);
    return menu;
  }

  public void save(Menu data) {
    Menu menu = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      menu = this.prepareMenuLoaded(data);
      dao.save(menu);
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE SAVE: " + exc.getMessage());
      throw exc;
    }
  }

  public void update(Menu data) {
    Menu menu = null;
    Menu menuUpdated = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      menu = this.findById(data.getId());
      if ((menu.getId() > 0) && (menu.isFlagState())) {
        menuUpdated = this.prepareMenuLoaded(data);
        menuUpdated.setId(data.getId());
        dao.update(menuUpdated);
      } else {
        throw new EmptyStackException();
      }
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE UPDATE: " + exc.getMessage());
      throw exc;
    }
  }

  public void delete(Menu data) {
    Menu menu = null;
    Menu menuDeleted = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      menu = this.findById(data.getId());
      if (menu.getId() > 0) {
        menuDeleted = new Menu();
        menuDeleted.setId(data.getId());
        dao.delete(menuDeleted);
      } else {
        throw new EmptyStackException();
      }
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE DELETE: " + exc.getMessage());
      throw exc;
    }
  }

  public Menu findById(Integer id) {
    Menu menu = null;
    Session session = null;
    IBasicDAO dao = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      menu = session.find(Menu.class, id);
      session.close();
      return menu;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return new Menu();
    }
  }

  public List<Menu> findAll() {
    Session session = null;
    Query<Menu> query = null;
    IBasicDAO dao = null;
    List<Menu> list = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      query = session.createQuery("SELECT objects FROM Menu AS objects", Menu.class);
      list = query.list();
      session.close();
      return list;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return new ArrayList<Menu>();
    }
  }

  public List<Menu> findAllByFlagState(boolean flagState) {
    Session session = null;
    Query<Menu> query = null;
    IBasicDAO dao = null;
    List<Menu> list = null;
    try {
      dao = new SimpleDAOImp();
      session = dao.getSession();
      query = session.createQuery("SELECT objects FROM Menu AS objects WHERE (flagState = :flagState)", Menu.class);
      query.setParameter("flagState", flagState);
      list = query.list();
      session.close();
      return list;
    } catch (HibernateException exc) {
      System.err.println("ERROR SERVICE FINDING: " + exc.getMessage());
      return new ArrayList<Menu>();
    }
  }
}
