
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PrinterTests extends Tests {
  private Printer printer = new Printer("FEUP");
  private Client client = new Client("Ruben", "povoa", quotes.Type1Quote.getInstance());
  private User user1 = new User("utilizador1", "password", client, quotes.Type1Quote.getInstance());
  private User user2 = new User("utilizador2", "password", client, quotes.Type1Quote.getInstance());
  private Document document1;

  private void testFunctionalPrinter() {

    assert_(Utils.equals(printer.checkFunctionalPrinter(), true));
  }

  private void testHasBlack() {

    assert_(Utils.equals(printer.checkValidPrintBlack(200L), false));
  }

  private void testHasColor() {

    assert_(Utils.equals(printer.checkValidPrintColor(100L), true));
  }

  private void testHaveNoUserLogged() {

    assert_(Utils.equals(printer.isFree(), true));
  }

  private void testLogin() {

    printer.login(user1);
    assert_(Utils.equals(printer.getUserLogged(), user1));
    printer.login(user2);
    assert_(Utils.equals(printer.getUserLogged(), user1));
  }

  private void testLogout() {

    printer.login(user1);
    assert_(Utils.equals(printer.getUserLogged(), user1));
    printer.logout();
    assert_(Utils.equals(printer.getUserLogged(), null));
  }

  private void testPossiblePrintBlackDocument() {

    document1 = user1.createBlackDocument(6L);
    assert_(Utils.equals(printer.possiblePrintBlackDocument(document1), false));
    printer.login(user1);
    assert_(Utils.equals(printer.possiblePrintBlackDocument(document1), false));
    user1.addToBalance(25L);
    assert_(Utils.equals(printer.possiblePrintBlackDocument(document1), false));
    user1.addToBalance(5L);
    assert_(Utils.equals(printer.possiblePrintBlackDocument(document1), true));
    printer.functional = false;
    assert_(Utils.equals(printer.possiblePrintBlackDocument(document1), false));
  }

  public static void main() {

    new PrinterTests().testFunctionalPrinter();
    new PrinterTests().testHasBlack();
    new PrinterTests().testHasColor();
    new PrinterTests().testHaveNoUserLogged();
    new PrinterTests().testLogin();
    new PrinterTests().testLogout();
    new PrinterTests().testPossiblePrintBlackDocument();
  }

  public PrinterTests() {}

  public String toString() {

    return "PrinterTests{"
        + "printer := "
        + Utils.toString(printer)
        + ", client := "
        + Utils.toString(client)
        + ", user1 := "
        + Utils.toString(user1)
        + ", user2 := "
        + Utils.toString(user2)
        + ", document1 := "
        + Utils.toString(document1)
        + "}";
  }
}
