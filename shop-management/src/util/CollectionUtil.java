package util;

import java.util.Collection;

/**
 * @author truongbb
 */
public class CollectionUtil {

  public static boolean isEmpty(Collection collection) {
    return collection == null || collection.isEmpty();
  }

}
