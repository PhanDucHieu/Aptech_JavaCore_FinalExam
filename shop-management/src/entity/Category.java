package entity;

import functionality.DataDisplayable;
import functionality.DataInputtable;

import java.io.Serializable;

/**
 * @author truongbb
 */
public class Category implements Serializable, DataInputtable, DataDisplayable {

  private int id;
  private String name;
  private String description;
  private int parentId;
  private boolean status;


  public Category() {
  }

  public Category(int id, String name, String description, int parentId, boolean status) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.parentId = parentId;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  @Override
  public void displayData() {
    // TODO - show category data
  }

  @Override
  public void inputData() {
    // TODO - input category data
  }

}
