package controller;

/**
 * @author DEV Scout
 */
public class SystemResponse {

  private short code;
  private boolean state;
  private String message;

  public SystemResponse() {}

  public short getCode() {
    return code;
  }

  public void setCode(short code) {
    this.code = code;
  }

  public boolean isState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
