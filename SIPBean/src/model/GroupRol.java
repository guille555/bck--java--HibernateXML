package model;

import java.util.Date;
import java.util.List;

/**
 * @author DEV Scout
 */
public class GroupRol {

  private Integer id;
  private String name;
  private boolean flagState;
  private Date registerDate;
  private SystemTag systemTag;
  private List<Menu> listMenus;
  private List<CompanyUser> listCompanyUsers;

  public GroupRol() {}

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

  public SystemTag getSystemTag() {
    return systemTag;
  }

  public void setSystemTag(SystemTag systemTag) {
    this.systemTag = systemTag;
  }

  public List<Menu> getListMenus() {
    return listMenus;
  }

  public void setListMenus(List<Menu> listMenus) {
    this.listMenus = listMenus;
  }

  public List<CompanyUser> getListCompanyUsers() {
    return listCompanyUsers;
  }

  public void setListCompanyUsers(List<CompanyUser> listCompanyUsers) {
    this.listCompanyUsers = listCompanyUsers;
  }
}
