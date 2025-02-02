package controller;

import java.util.List;
import model.GroupRol;
import model.SystemTag;
import service.GroupRolService;

/**
 * @author DEV Scout
 */
public class GroupRolController {

  public GroupRolController() {}

  private SystemTag returnSystemTagLoaded(Integer id) {
    SystemTag systemTag = new SystemTag();
    systemTag.setId(id);
    return systemTag;
  }

  private GroupRol returnDataLoaded(Integer id, String name, Integer idSytemTag) {
    SystemTag systemTag = this.returnSystemTagLoaded(idSytemTag);
    GroupRol groupRol = new GroupRol();
    groupRol.setId(id);
    groupRol.setName(name);
    groupRol.setSystemTag(systemTag);
    return groupRol;
  }

  public SystemResponse save(String name, Integer idSystemTag) {
    GroupRol groupRol = null;
    GroupRolService service = null;
    UtilController util = new UtilController();
    try {
      service = new GroupRolService();
      groupRol = this.returnDataLoaded(null, name, idSystemTag);
      service.save(groupRol);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE SAVE: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("bad operation");
    }
  }

  public SystemResponse update(Integer id, String name, Integer idSystemTag) {
    GroupRol groupRol = null;
    GroupRolService service = null;
    UtilController util = new UtilController();
    try {
      service = new GroupRolService();
      groupRol = this.returnDataLoaded(id, name, idSystemTag);
      service.update(groupRol);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE UPDATE: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("bad operation");
    }
  }

  public SystemResponse delete(Integer id) {
    GroupRol groupRol = null;
    GroupRolService service = null;
    UtilController util = new UtilController();
    try {
      service = new GroupRolService();
      groupRol = this.returnDataLoaded(id, null, null);
      service.delete(groupRol);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR SERVICE DELETE: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("bad operation");
    }
  }

  public GroupRol findById(Integer id) {
    GroupRolService service = new GroupRolService();
    GroupRol groupRol = service.findById(id);
    return groupRol;
  }

  public List<GroupRol> findAll() {
    GroupRolService service = new GroupRolService();
    List<GroupRol> list = service.findAll();
    return list;
  }

  public List<GroupRol> findAllByFlagState(boolean flagState) {
    GroupRolService service = new GroupRolService();
    List<GroupRol> list = service.findAllByFlagState(flagState);
    return list;
  }
}
