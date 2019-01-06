
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class UserTests extends Tests {
  private Company company = new Company();
  private Client client = new Client("Ruben", "povoa", company);
  private User user = new User("utilizador", "password", client);
  private User user2 = new User("utilizador2", "password", client);
  private Document document1 = new Document(6L, "PB", "title", user);
  private Document documentPB = null;
  private Document documentCor = null;
  private Document document = null;

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

    user2.addDocument(document1);
    assert_(Utils.equals(SetUtil.inSet(document1, user2.getDocuments()), true));
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

    user.removeDocument(document1);
    assert_(Utils.equals(SetUtil.inSet(document1, user.getDocuments()), false));
  }

  private void testGetDocument() {

    document = user.getDocument(document1.title, document1.num_sheets);
    assert_(Utils.equals(document, document1));
  }

  private void testGetPassword() {

    assert_(Utils.equals(user.getPassword(), "password"));
  }

  private void testEnoughBalance() {

    user.addToBalance(10L);
    assert_(Utils.equals(user.enoughBalance(11L), false));
    assert_(Utils.equals(user.enoughBalance(8L), true));
  }

  private void testHasDocument() {

    assert_(Utils.equals(user.hasDocument(document1), true));
    assert_(Utils.equals(user2.hasDocument(document1), false));
  }

  private void testLoginToPrinter() {

    Printer printer = null;
    Printer printer2 = null;
    Printer printerLogged = null;
    printer = client.getFreePrinter();
    assert_(Utils.equals(printer, null));
    printer = new Printer("FEUP", client);
    printer2 = user.loginToPrinter();
    assert_(Utils.equals(printer, printer2));
    printerLogged = user.loginToPrinter();
    assert_(Utils.equals(printer, printerLogged));
  }

  public static void main() {

    new UserTests().testGetBalance();
    new UserTests().testAddAndWithdrawBalance();
    new UserTests().testGetUsername();
    new UserTests().testAddDocument();
    new UserTests().testCreateBlackDocument();
    new UserTests().testCreateColorDocument();
    new UserTests().testRemoveDocument();
    new UserTests().testGetDocument();
    new UserTests().testGetPassword();
    new UserTests().testEnoughBalance();
    new UserTests().testHasDocument();
    new UserTests().testLoginToPrinter();
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
        + ", user2 := "
        + Utils.toString(user2)
        + ", document1 := "
        + Utils.toString(document1)
        + ", documentPB := "
        + Utils.toString(documentPB)
        + ", documentCor := "
        + Utils.toString(documentCor)
        + ", document := "
        + Utils.toString(document)
        + "}";
  }
}
