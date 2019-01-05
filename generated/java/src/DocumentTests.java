
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DocumentTests extends Tests {
  private Company company = new Company();
  private Client client = new Client("Ruben", "povoa", company);
  private User user = new User("utilizador", "password", client);
  private Document document1 = new Document(6L, "PB", "title", user);
  private Document document2 = new Document(6L, "Cor", "title", user);
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

  public void testGetUser() {

    assert_(Utils.equals(document1.getUser(), user));
  }

  public void testEquals() {

    assert_(Utils.equals(Document.cg_equals(document1, document2), false));
    assert_(Utils.equals(Document.cg_equals(document1, document1), true));
  }

  public static void main() {

    new DocumentTests().testgetType();
    new DocumentTests().testTotalPrice();
    new DocumentTests().testgetNumSheets();
    new DocumentTests().testGetUser();
    new DocumentTests().testEquals();
  }

  public DocumentTests() {}

  public String toString() {

    return "DocumentTests{"
        + "company := "
        + Utils.toString(company)
        + ", client := "
        + Utils.toString(client)
        + ", user := "
        + Utils.toString(user)
        + ", document1 := "
        + Utils.toString(document1)
        + ", document2 := "
        + Utils.toString(document2)
        + ", typeDocument := "
        + Utils.toString(typeDocument)
        + "}";
  }
}
