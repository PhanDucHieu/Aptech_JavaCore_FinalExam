package util;

import entity.Category;
import entity.Product;

import java.io.*;
import java.util.List;

/**
 * @author truongbb
 */
public class FileUtil {

  public static final String PRODUCT_CLASS_NAME = "Product";
  public static final String CATEGORY_CLASS_NAME = "Category";

  public static List<?> readDataObject(String fileName, String className) throws IOException, ClassNotFoundException {

    if (StringUtil.isNullOrEmpty(fileName) || StringUtil.isNullOrEmpty(className)) {
      return null;
    }

    try (FileInputStream fis = new FileInputStream(fileName);
         ObjectInputStream ois = new ObjectInputStream(fis)) {
      if (PRODUCT_CLASS_NAME.equals(className)) {
        return (List<Product>) ois.readObject();
      } else if (CATEGORY_CLASS_NAME.equals(className)) {
        return (List<Category>) ois.readObject();
      }
    }
    return null;
  }

  public static <T> void writeDataObject(List<T> data, String fileName) throws IOException {

    if (CollectionUtil.isEmpty(data)) {
      return;
    }

    if (StringUtil.isNullOrEmpty(fileName)) {
      return;
    }

    File file = new File(fileName);
    try (
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos)
    ) {
      oos.writeObject(data);
    }
  }

}
