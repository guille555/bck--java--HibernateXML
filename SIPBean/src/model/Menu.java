package model;

import java.util.Date;

/**
 * @author DEV Scout
 */
public class Menu {

  private Integer id;
  private String name;
  private boolean flagState;
  private Date registerDate;
  private GroupRol groupRol;

  public Menu() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public GroupRol getGroupRol() {
    return groupRol;
  }

  public void setGroupRol(GroupRol groupRol) {
    this.groupRol = groupRol;
  }
}
