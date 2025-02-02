package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author DEV Scout
 */
public class SystemTag implements Serializable {

  private Integer id;
  private String name;
  private boolean flagState;
  private Date registerDate;
  private List<GroupRol> listGroupRoles;
  private List<CompanyUser> listCompanyUsers;

  public SystemTag() {}

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

  public List<GroupRol> getListGroupRoles() {
    return listGroupRoles;
  }

  public void setListGroupRoles(List<GroupRol> listGroupRoles) {
    this.listGroupRoles = listGroupRoles;
  }

  public List<CompanyUser> getListCompanyUsers() {
    return listCompanyUsers;
  }

  public void setListCompanyUsers(List<CompanyUser> listCompanyUsers) {
    this.listCompanyUsers = listCompanyUsers;
  }
}
