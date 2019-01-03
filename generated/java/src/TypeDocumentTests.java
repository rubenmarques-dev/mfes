
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TypeDocumentTests extends Tests {
  private TypeDocument typeDocument = new TypeDocument();

  private void testTypeDocument() {

    assert_(
        Utils.equals(
            typeDocument.getTipos(), MapUtil.map(new Maplet("Cor", 9L), new Maplet("PB", 5L))));
    assert_(Utils.equals(typeDocument.getDomain(), SetUtil.set("Cor", "PB")));
    assert_(Utils.equals(typeDocument.getRange(), SetUtil.set(9L, 5L)));
    assert_(Utils.equals(typeDocument.getPrice("Cor"), 9L));
    assert_(Utils.equals(typeDocument.getPrice("PB"), 5L));
  }

  public static void main() {

    new TypeDocumentTests().testTypeDocument();
  }

  public TypeDocumentTests() {}

  public String toString() {

    return "TypeDocumentTests{" + "typeDocument := " + Utils.toString(typeDocument) + "}";
  }
}
