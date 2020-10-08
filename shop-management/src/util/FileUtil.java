package util;

import java.io.*;
import java.util.List;

/**
 * @author truongbb
 */
public class FileUtil {

  public static Object readDataObject(String fileName) throws IOException, ClassNotFoundException {

    if (StringUtil.isNullOrEmpty(fileName)) {
      return null;
    }

    try (FileInputStream fis = new FileInputStream(fileName);
         ObjectInputStream ois = new ObjectInputStream(fis)) {
      return ois.readObject();
    }
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
