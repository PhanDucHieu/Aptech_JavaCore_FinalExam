package util;

/**
 * @author truongbb
 */
public class StringUtil {

  public static boolean isNullOrEmpty(String obj) {
    return obj == null || obj.isEmpty() || obj.trim().isEmpty();
  }

}
