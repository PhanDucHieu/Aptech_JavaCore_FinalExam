package main.product;

import java.util.Scanner;

/**
 * @author truongbb
 */
public class ProductDetail {


  public static void productInfoMenu() {
    boolean backToProductMenu = false;
    while (!backToProductMenu) {
      System.out.println("******************* SHOP MANAGEMENT - PRODUCT DETAIL *******************");
      System.out.println("1. Show products by category");
      System.out.println("2. Show details of product by name");
      System.out.println("3. Back to product menu");
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
          showInfoByCategory();
          break;
        case 2:
          showInfoByName();
          break;
        case 3:
          backToProductMenu = true;
          break;
        default:
          break;
      }
    }
  }

  private static void showInfoByName() {
    // TODO - show product info by name
  }

  private static void showInfoByCategory() {
    // TODO - show product info by category
  }

  public static void sortedProductMenu() {
    boolean backToProductMenu = false;
    while (!backToProductMenu) {
      System.out.println("************************ SHOP MANAGEMENT - PRODUCT SORTING ***********************");
      System.out.println("1. Sort products by price ascending");
      System.out.println("2. Sort products by profit descending");
      System.out.println("3. Back to product menu");
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
          sortByPrice();
          break;
        case 2:
          sortByProfit();
          break;
        case 3:
          backToProductMenu = true;
          break;
        default:
          break;
      }
    }
  }

  private static void sortByProfit() {
    // TODO - sort ASC by price using sort of Collections
    /** Reference:
     *
     * - https://dzone.com/articles/java-8-comparator-how-to-sort-a-list
     * - https://mkyong.com/java8/java-8-how-to-sort-list-with-stream-sorted/
     * - https://howtodoinjava.com/java/sort/collections-sort/
     * - https://beginnersbook.com/2017/10/java-8-lambda-comparator-example-for-sorting-list-of-custom-objects/
     */
  }

  private static void sortByPrice() {
    // TODO - sort ASC by price using sort of Collections
    /** Reference:
     *
     * - https://dzone.com/articles/java-8-comparator-how-to-sort-a-list
     * - https://mkyong.com/java8/java-8-how-to-sort-list-with-stream-sorted/
     * - https://howtodoinjava.com/java/sort/collections-sort/
     * - https://beginnersbook.com/2017/10/java-8-lambda-comparator-example-for-sorting-list-of-custom-objects/
     */
  }

}
