
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class UserTests extends Tests {
  private Client client = new Client("Ruben", "povoa", quotes.Type1Quote.getInstance());
  private User user = new User("utilizador", "password", client, quotes.Type1Quote.getInstance());
  private Document document1 = new Document(6L, "PB", user);
  private Document documentPB;
  private Document documentCor;

  private void testGetBalance() {

    assert_(Utils.equals(user.getBalance(), 0L));
  }

  private void testAddAndWithdrawBalance() {

    user.addToBalance(33L);
    assert_(Utils.equals(user.getBalance(), 33L));
    user.withdrawFromBalance(11L);
    assert_(Utils.equals(user.getBalance(), 22L));
  }

  private void testGetUsername() {

    assert_(Utils.equals(user.getUsername(), "utilizador"));
  }

  private void testAddDocument() {

    user.addDocument(document1);
    assert_(Utils.equals(((Document) user.getDocuments().get(0)), document1));
  }

  private void testCreateBlackDocument() {

    documentPB = user.createBlackDocument(6L);
    assert_(Utils.equals(((Document) user.getDocuments().get(0)), documentPB));
  }

  private void testCreateColorDocument() {

    documentPB = user.createBlackDocument(6L);
    assert_(Utils.equals(((Document) user.getDocuments().get(0)), documentPB));
    documentCor = user.createColorDocument(6L);
    assert_(Utils.equals(((Document) user.getDocuments().get(0)), documentCor));
  }

  public static void main() {

    new UserTests().testGetBalance();
    new UserTests().testAddAndWithdrawBalance();
    new UserTests().testGetUsername();
    new UserTests().testAddDocument();
    new UserTests().testCreateBlackDocument();
    new UserTests().testCreateColorDocument();
  }

  public UserTests() {}

  public String toString() {

    return "UserTests{"
        + "client := "
        + Utils.toString(client)
        + ", user := "
        + Utils.toString(user)
        + ", document1 := "
        + Utils.toString(document1)
        + ", documentPB := "
        + Utils.toString(documentPB)
        + ", documentCor := "
        + Utils.toString(documentCor)
        + "}";
  }
}
