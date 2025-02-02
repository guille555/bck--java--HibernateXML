package controller;

import java.util.List;
import model.GroupRol;
import model.Menu;
import service.MenuService;

/**
 * @author DEV Scout
 */
public class MenuController {

  public MenuController() {}

  private GroupRol returnGroupRolLoaded(Integer id) {
    GroupRol groupRol = new GroupRol();
    groupRol.setId(id);
    return groupRol;
  }

  private Menu returnDataLoaded(Integer id, String name, Integer idGroupRol) {
    GroupRol groupRol = this.returnGroupRolLoaded(idGroupRol);
    Menu data = new Menu();
    data.setId(id);
    data.setName(name);
    data.setGroupRol(groupRol);
    return data;
  }

  public SystemResponse save(String name, Integer idGroupRol) {
    Menu menu = null;
    MenuService service = null;
    UtilController util = new UtilController();
    try {
      service = new MenuService();
      menu = this.returnDataLoaded(null, name, idGroupRol);
      service.save(menu);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR CONTROLLER SAVE: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("bad operation");
    }
  }

  public SystemResponse update(Integer id, String name, Integer idGroupRol) {
    Menu menu = null;
    MenuService service = null;
    UtilController util = new UtilController();
    try {
      service = new MenuService();
      menu = this.returnDataLoaded(id, name, idGroupRol);
      service.update(menu);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR CONTROLLER UPDATE: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("bad operation");
    }
  }

  public SystemResponse delete(Integer id) {
    Menu menu = null;
    MenuService service = null;
    UtilController util = new UtilController();
    try {
      service = new MenuService();
      menu = this.returnDataLoaded(id, null, null);
      service.delete(menu);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR CONTROLLER DELETE: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("bad operation");
    }
  }

  public Menu findById(Integer id) {
    MenuService service = new MenuService();
    Menu menu = service.findById(id);
    return menu;
  }

  public List<Menu> findAll() {
    MenuService service = new MenuService();
    List<Menu> list = service.findAll();
    return list;
  }

  public List<Menu> findAllByFlagState(boolean flagState) {
    MenuService service = new MenuService();
    List<Menu> list = service.findAllByFlagState(flagState);
    return list;
  }
}
