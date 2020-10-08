package entity;

import functionality.DataDisplayable;
import functionality.DataInputtable;
import functionality.ProfitComputable;

import java.io.Serializable;

/**
 * @author truongbb
 */
public class Product implements Serializable, DataInputtable, DataDisplayable, ProfitComputable {

  private String id;
  private String name;
  private String title;
  private float importPrice;
  private float exportPrice;
  private String description;
  private boolean status;
  private Category catalog;


  public Product() {
  }

  public Product(String id, String name, String title, float importPrice, float exportPrice, String description, boolean status, Category catalog) {
    this.id = id;
    this.name = name;
    this.title = title;
    this.importPrice = importPrice;
    this.exportPrice = exportPrice;
    this.description = description;
    this.status = status;
    this.catalog = catalog;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public float getImportPrice() {
    return importPrice;
  }

  public void setImportPrice(float importPrice) {
    this.importPrice = importPrice;
  }

  public float getExportPrice() {
    return exportPrice;
  }

  public void setExportPrice(float exportPrice) {
    this.exportPrice = exportPrice;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public Category getCatalog() {
    return catalog;
  }

  public void setCatalog(Category catalog) {
    this.catalog = catalog;
  }

  @Override
  public void displayData() {
    // TODO - show product info, when you want to show profit data, call calculateProfit() method bellow
  }

  @Override
  public void inputData() {
    // TODO - input product data
  }

  @Override
  public float calculateProfit() {
    // TODO - calculate profit data
    return 0;
  }

}
