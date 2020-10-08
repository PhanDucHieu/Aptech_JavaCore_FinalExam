package main.product;

import constant.FileUtilConstant;
import entity.Product;
import util.FileUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author truongbb
 */
public class ProductManagement {

  private static List<Product> products;

  static {
    try {
      products = (List<Product>) FileUtil.readDataObject(FileUtilConstant.PRODUCT_FILE_NAME);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void menu() {
    boolean backToMainMenu = false;
    while (!backToMainMenu) {
      System.out.println("******************* SHOP MANAGEMENT: PRODUCT MANAGEMENT ******************");
      System.out.println("1. Add new products");
      System.out.println("2. Calculate product profit");
      System.out.println("3. Show product detail");
      System.out.println("4. Sort products");
      System.out.println("5. Update product information");
      System.out.println("6. Update product status");
      System.out.println("7. Back to main menu");
      System.out.println("Please choose an item: ");

      int chosenItem;
      while (true) {
        try {
          chosenItem = Integer.parseInt(new Scanner(System.in).nextLine());
          if (chosenItem >= 1 && chosenItem <= 7) {
            break;
          }
          System.err.println("Please choose a number between 1 to 7. Try again: ");
        } catch (NumberFormatException e) {
          System.err.println("Please choose a integer number. Try again: ");
        }
      }

      switch (chosenItem) {
        case 1:
          addNewProducts();
          break;
        case 2:
          calculateProfit();
          break;
        case 3:
          ProductDetail.productInfoMenu();
          break;
        case 4:
          ProductDetail.sortedProductMenu();
          break;
        case 5:
          updateProductInfo();
          break;
        case 6:
          updateProductStatus();
          break;
        case 7:
          backToMainMenu = true;
          break;
        default:
          break;
      }
    }
  }

  private static void updateProductStatus() {
    // TODO - update product status
  }

  private static void updateProductInfo() {
    // TODO - update product info
  }

  private static void calculateProfit() {
    //TODO - calculate profit
  }

  private static void addNewProducts() {
    // TODO - add new products
  }


  public static void writeData() {
    try {
      FileUtil.writeDataObject(products, FileUtilConstant.PRODUCT_FILE_NAME);
      System.exit(0);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
