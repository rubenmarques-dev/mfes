
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DocumentTests extends Tests {
  private Client client = new Client("Ruben", "povoa", quotes.Type1Quote.getInstance());
  private User user = new User("utilizador", "password", client, quotes.Type1Quote.getInstance());
  private Document document1 = new Document(6L, "PB", user);
  private TypeDocument typeDocument = new TypeDocument();

  public void testTotalPrice() {

    assert_(
        Utils.equals(
            document1.getTotalPrice(),
            document1.getNumSheets().longValue()
                * typeDocument.getPrice(document1.getType()).longValue()));
  }

  public void testgetType() {

    assert_(Utils.equals(document1.getType(), "PB"));
  }

  public void testgetNumSheets() {

    assert_(Utils.equals(document1.getNumSheets(), 6L));
  }

  public static void main() {

    new DocumentTests().testgetType();
    new DocumentTests().testTotalPrice();
    new DocumentTests().testgetNumSheets();
  }

  public DocumentTests() {}

  public String toString() {

    return "DocumentTests{"
        + "client := "
        + Utils.toString(client)
        + ", user := "
        + Utils.toString(user)
        + ", document1 := "
        + Utils.toString(document1)
        + ", typeDocument := "
        + Utils.toString(typeDocument)
        + "}";
  }
}
