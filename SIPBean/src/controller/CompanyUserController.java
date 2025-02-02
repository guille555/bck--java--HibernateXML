package controller;

import java.util.List;
import model.CompanyUser;
import model.GroupRol;
import model.SystemTag;
import service.CompanyUserService;

/**
 * @author DEV Scout
 */
public class CompanyUserController {

  public CompanyUserController() {}

  private SystemTag returnSystemTagLoaded(Integer id) {
    SystemTag systemTag = new SystemTag();
    systemTag.setId(id);
    return systemTag;
  }

  private GroupRol returnGroupRolLoaded(Integer id) {
    GroupRol groupRol = new GroupRol();
    groupRol.setId(id);
    return groupRol;
  }

  private CompanyUser returnDataLoaded(Long id, String username, String password, Integer idSystemTag, Integer idGroupRol) {
    SystemTag systemTag = this.returnSystemTagLoaded(idSystemTag);
    GroupRol groupRoll = this.returnGroupRolLoaded(idGroupRol);
    CompanyUser companyUser = new CompanyUser();
    companyUser.setId(id);
    companyUser.setUsername(username);
    companyUser.setPassword(password);
    companyUser.setSystemTag(systemTag);
    companyUser.setGroupRol(groupRoll);
    return companyUser;
  }

  public SystemResponse save(String username, String password, Integer idSystemTag, Integer idGroupRol) {
    CompanyUser companyUser = null;
    CompanyUserService service = null;
    UtilController util = new UtilController();
    try {
      service = new CompanyUserService();
      companyUser = this.returnDataLoaded(null, username, password, idSystemTag, idGroupRol);
      service.save(companyUser);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR SAVE CONTROLLER: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("bad operation");
    }
  }

  public SystemResponse update(Long id, String username, String password, Integer idSystemTag, Integer idGroupRol) {
    CompanyUser companyUser = null;
    CompanyUserService service = null;
    UtilController util = new UtilController();
    try {
      service = new CompanyUserService();
      companyUser = this.returnDataLoaded(id, username, password, idSystemTag, idGroupRol);
      service.update(companyUser);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR UPDATE CONTROLLER: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("bad operation");
    }
  }

  public SystemResponse delete(Long id) {
    CompanyUser companyUser = null;
    CompanyUserService service = null;
    UtilController util = new UtilController();
    try {
      service = new CompanyUserService();
      companyUser = this.returnDataLoaded(id, null, null, null, null);
      service.delete(companyUser);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR DELETE CONTROLLER: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("bad operation");
    }
  }

  public CompanyUser findById(Long id) {
    CompanyUserService service = new CompanyUserService();
    CompanyUser companyUser = service.findById(id);
    return companyUser;
  }

  public List<CompanyUser> findAll() {
    CompanyUserService service = new CompanyUserService();
    List<CompanyUser> list = service.findAll();
    return list;
  }

  public List<CompanyUser> findAllByFlagState(boolean flagState) {
    CompanyUserService service = new CompanyUserService();
    List<CompanyUser> list = service.findAllByFlagState(flagState);
    return list;
  }
}
