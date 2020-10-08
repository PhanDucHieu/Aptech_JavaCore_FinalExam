package main.category;

import constant.FileUtilConstant;
import entity.Category;
import util.FileUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author truongbb
 */
public class CategoryManagement {

  private static List<Category> categories;

  static {
    try {
      categories = (List<Category>) FileUtil.readDataObject(FileUtilConstant.CATEGORY_FILE_NAME);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void menu() {
    boolean backToMainMenu = false;
    while (!backToMainMenu) {
      System.out.println("**************** SHOP MANAGEMENT: CATEGORY MANAGEMENT *****************");
      System.out.println("1. Show categories");
      System.out.println("2. Add new a category");
      System.out.println("3. Remove a category");
      System.out.println("4. Find a category by name");
      System.out.println("5. Back to main menu");
      System.out.println("Please choose an item: ");

      int chosenItem;
      while (true) {
        try {
          chosenItem = Integer.parseInt(new Scanner(System.in).nextLine());
          if (chosenItem >= 1 && chosenItem <= 5) {
            break;
          }
          System.err.println("Please choose a number between 1 to 5. Try again: ");
        } catch (NumberFormatException e) {
          System.err.println("Please choose a integer number. Try again: ");
        }
      }

      switch (chosenItem) {
        case 1:
          CategoryDetail.menu();
          break;
        case 2:
          addNewCategory();
          break;
        case 3:
          deleteCategory();
          break;
        case 4:
          findByName();
          break;
        case 5:
          backToMainMenu = true;
          break;
        default:
          break;
      }
    }
  }

  private static void findByName() {
    // TODO - find category by name
  }

  private static void addNewCategory() {
    // TODO - add new category use inputData in Category class
  }

  private static void deleteCategory() {
    //TODO - delete a category use "products" from ProductManagement class
  }

  public static void writeData() {
    try {
      FileUtil.writeDataObject(categories, FileUtilConstant.CATEGORY_FILE_NAME);
      System.exit(0);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
