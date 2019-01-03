package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Type2Quote {
  private static int hc = 0;
  private static Type2Quote instance = null;

  public Type2Quote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static Type2Quote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new Type2Quote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof Type2Quote;
  }

  public String toString() {

    return "<Type2>";
  }
}
