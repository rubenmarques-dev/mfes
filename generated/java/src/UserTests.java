
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class UserTests extends Tests {
  private Company company = new Company();
  private Client client = new Client("Ruben", "povoa", company);
  private User user = new User("utilizador", "password", client);
  private Document document1 = new Document(6L, "PB", "title", user);
  private Document documentPB = null;
  private Document documentCor = null;

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
    assert_(Utils.equals(SetUtil.inSet(document1, user.getDocuments()), true));
  }

  private void testCreateBlackDocument() {

    documentPB = user.createBlackDocument(6L, "title_pb");
    assert_(Utils.equals(SetUtil.inSet(documentPB, user.getDocuments()), true));
  }

  private void testCreateColorDocument() {

    documentPB = user.createBlackDocument(6L, "title_pb");
    assert_(Utils.equals(SetUtil.inSet(documentPB, user.getDocuments()), true));
    documentCor = user.createColorDocument(6L, "title_cor");
    assert_(Utils.equals(SetUtil.inSet(documentCor, user.getDocuments()), true));
  }

  private void testRemoveDocument() {

    user.addDocument(document1);
    assert_(Utils.equals(SetUtil.inSet(document1, user.getDocuments()), true));
    user.removeDocument(document1);
    assert_(Utils.equals(SetUtil.inSet(document1, user.getDocuments()), false));
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
        + "company := "
        + Utils.toString(company)
        + ", client := "
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
