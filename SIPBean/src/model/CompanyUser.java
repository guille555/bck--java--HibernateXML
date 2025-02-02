package model;

import java.util.Date;

/**
 * @author DEV Scout
 */
public class CompanyUser {

  private Long id;
  private String username;
  private String password;
  private boolean flagState;
  private Date registerDate;
  private SystemTag systemTag;
  private GroupRol groupRol;

  public CompanyUser() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isFlagState() {
    return flagState;
  }

  public void setFlagState(boolean flagState) {
    this.flagState = flagState;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }

  public SystemTag getSystemTag() {
    return systemTag;
  }

  public void setSystemTag(SystemTag systemTag) {
    this.systemTag = systemTag;
  }

  public GroupRol getGroupRol() {
    return groupRol;
  }

  public void setGroupRol(GroupRol groupRol) {
    this.groupRol = groupRol;
  }
}
