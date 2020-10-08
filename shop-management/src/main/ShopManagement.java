package main;

import main.category.CategoryManagement;
import main.product.ProductManagement;

import java.util.Scanner;

/**
 * @author truongbb
 */
public class ShopManagement {

  public static void main(String[] args) {
    menu();
  }

  private static void menu() {
    while (true) {
      System.out.println("********************** SHOP MANAGEMENT MENU ************************");
      System.out.println("1. Category management");
      System.out.println("2. Product management");
      System.out.println("3. Cancel and exit");
      System.out.println("Please choose an item: ");

      int chosenItem;
      while (true) {
        try {
          chosenItem = Integer.parseInt(new Scanner(System.in).nextLine());
          if (chosenItem >= 1 && chosenItem <= 3) {
            break;
          }
          System.err.println("Please choose a number between 1 to 3. Try again: ");
        } catch (NumberFormatException e) {
          System.err.println("Please choose a integer number. Try again: ");
        }
      }

      switch (chosenItem) {
        case 1:
          CategoryManagement.menu();
          break;
        case 2:
          ProductManagement.menu();
          break;
        case 3:
          writeDataAndExit();
        default:
          break;
      }
    }
  }

  private static void writeDataAndExit() {
    CategoryManagement.writeData();
    ProductManagement.writeData();
    System.exit(0);
  }

}
