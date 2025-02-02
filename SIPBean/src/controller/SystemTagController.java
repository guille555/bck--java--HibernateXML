package controller;

import java.util.List;
import model.SystemTag;
import service.SystemTagService;

/**
 * @author DEV Scout
 */
public class SystemTagController {

  public SystemTagController() {}

  private SystemTag returnDataLoaded(Integer id, String name) {
    SystemTag data = new SystemTag();
    data.setId(id);
    data.setName(name);
    return data;
  }

  public SystemResponse save(String name) {
    SystemTag data = null;
    SystemTagService service = null;
    UtilController util = new UtilController();
    try {
      service = new SystemTagService();
      data = this.returnDataLoaded(null, name);
      service.save(data);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR CONTROLLER SAVE: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("error");
    }
  }

  public SystemResponse update(Integer id, String name) {
    SystemTag data = null;
    SystemTagService service = null;
    UtilController util = new UtilController();
    try {
      service = new SystemTagService();
      data = this.returnDataLoaded(id, name);
      service.update(data);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR CONTROLLER UPDATE: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("error");
    }
  }

  public SystemResponse delete(Integer id) {
    SystemTag data = null;
    SystemTagService service = null;
    UtilController util = new UtilController();
    try {
      service = new SystemTagService();
      data = this.returnDataLoaded(id, null);
      service.delete(data);
      return util.returnSuccessfulResponse();
    } catch (Exception exc) {
      System.err.println("ERROR CONTROLLER SAVE: " + exc.getMessage());
      return util.returnUnsuccessfulResponse("error");
    }
  }

  public SystemTag findById(Integer id) {
    SystemTagService service = new SystemTagService();
    return service.findById(id);
  }

  public List<SystemTag> findAll() {
    SystemTagService service = new SystemTagService();
    List<SystemTag> list = service.findAll();
    return list;
  }

  public List<SystemTag> findAllByFlagState(boolean flagState) {
    SystemTagService service = new SystemTagService();
    List<SystemTag> list = service.findAllByFlagState(flagState);
    return list;
  }
}
