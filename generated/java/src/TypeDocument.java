
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TypeDocument {
  private VDMMap tipos = MapUtil.map(new Maplet("Cor", 9L), new Maplet("PB", 5L));

  public VDMMap getTipos() {

    return Utils.copy(tipos);
  }

  public VDMSet getDomain() {

    return MapUtil.dom(Utils.copy(tipos));
  }

  public VDMSet getRange() {

    return MapUtil.rng(Utils.copy(tipos));
  }

  public Number getPrice(final String type) {

    return ((Number) Utils.get(tipos, type));
  }

  public TypeDocument() {}

  public String toString() {

    return "TypeDocument{" + "tipos := " + Utils.toString(tipos) + "}";
  }
}
