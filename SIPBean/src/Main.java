
import persistence.DBPersistence;

/**
 * @author DEV Scout
 */
public class Main {

  public static void main(String[] args) {
    // *** CONTROLLERS
    /*
    SystemTagController controllerSystemTag = new SystemTagController();
    GroupRolController controllerGroupRol = new GroupRolController();
    MenuController controllerMenu = new MenuController();
    CompanyUserController controllerUser = new CompanyUserController();
    */

    // *** CRUD "SYSTEM_TAG"
    /*
    controllerSystemTag.save("sys1");
    controllerSystemTag.save("sys2");
    controllerSystemTag.save("sys3");
    */
    //controllerSystemTag.update(2, "sys_upd_2");
    //controllerSystemTag.delete(2);
    /*
    List<SystemTag> list = controllerSystemTag.findAll();
    for (SystemTag item : list) {
      System.out.println("ELEMENT (system_tag): " + item.getName());
    }
    */
    
    // *** CRUD GROUP_ROL
    /*
    controllerGroupRol.save("group1", 1);
    controllerGroupRol.save("group2", 1);
    controllerGroupRol.save("group3", 3);
    */
    //controllerGroupRol.update(2, "group2_upd", 1);
    //controllerGroupRol.delete(2);
    /*
    List<GroupRol> listGroup = controllerGroupRol.findAll();
    for (GroupRol item : listGroup) {
      System.out.println("ELEMENT (group_rol): " + item.getName());
    }
    */

    // *** CRUD MENU
    /*
    controllerMenu.save("menu01", 1);
    controllerMenu.save("menu02", 1);
    controllerMenu.save("menu03", 1);
    */
    //controllerMenu.update(2, "menu02_upd", 1);
    //controllerMenu.delete(3);
    /*
    List<Menu> listMenu = controllerMenu.findAll();
    for (Menu item : listMenu) {
      System.out.println("ELEMENT (menu): " + item.getName());
    }
    */

    // *** CRUD COMPANY USER
    /*
    controllerUser.save("user01", "pass", 1, 1);
    controllerUser.save("user02", "pass", 3, 2);
    controllerUser.save("user03", "pass", 3, 3);
    */
    //controllerUser.update(2L, "user02_upd", "pass", 2, 2);
    //controllerUser.delete(3L);
    /*
    List<CompanyUser> listUsers = controllerUser.findAll();
    for (CompanyUser item : listUsers) {
      System.out.println("ELEMENT (company_user): " + item.getUsername());
    }
    */
    DBPersistence.closeConnection();
    DBPersistence.closeDB();
  }
}
