package controller;

/**
 * @author DEV Scout
 */
public class UtilController {

  public UtilController() {}

  public SystemResponse returnSuccessfulResponse() {
    SystemResponse response = new SystemResponse();
    response.setCode((short) 200);
    response.setState(true);
    response.setMessage("ok");
    return response;
  }

  public SystemResponse returnUnsuccessfulResponse(String message) {
    SystemResponse response = new SystemResponse();
    response.setCode((short) 500);
    response.setState(false);
    response.setMessage(message);
    return response;
  }
}
