package main.category;

import java.util.Scanner;

/**
 * @author truongbb
 */
public class CategoryDetail {

  public static void menu() {
    boolean backToCategoryMenu = false;
    while (!backToCategoryMenu) {
      System.out.println("****************** SHOP MANAGEMENT - CATEGORY DETAIL *****************");
      System.out.println("1. Show a category tree");
      System.out.println("2. Show details of category");
      System.out.println("3. Back to category menu");
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
          showCategoryTree();
          break;
        case 2:
          showCategoryInfo();
          break;
        case 3:
          backToCategoryMenu = true;
          break;
        default:
          break;
      }

    }
  }

  private static void showCategoryInfo() {
    // TODO - show category information
  }

  private static void showCategoryTree() {
    // TODO - show category tree
  }

}
