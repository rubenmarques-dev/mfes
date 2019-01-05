
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PrinterTests extends Tests {
  private Company company = new Company();
  private Client client = new Client("Ruben", "povoa", company);
  private Printer printer = new Printer("FEUP", client);
  private User user1 = new User("utilizador1", "password", client);
  private User user2 = new User("utilizador2", "password", client);
  private Document document1 = null;
  private Employee employee = null;

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

    document1 = user1.createBlackDocument(6L, "title_pb");
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

  private void testPossiblePrintColorDocument() {

    document1 = user1.createColorDocument(50L, "title_cor");
    assert_(Utils.equals(printer.possiblePrintColorDocument(document1), false));
    printer.login(user1);
    assert_(Utils.equals(printer.possiblePrintColorDocument(document1), false));
    user1.addToBalance(300L);
    assert_(Utils.equals(printer.possiblePrintColorDocument(document1), false));
    user1.addToBalance(160L);
    assert_(Utils.equals(printer.possiblePrintColorDocument(document1), true));
    printer.functional = false;
    assert_(Utils.equals(printer.possiblePrintColorDocument(document1), false));
  }

  private void testPrintBlackDocument() {

    document1 = user1.createBlackDocument(6L, "title_pb");
    user1.addToBalance(30L);
    printer.printBlackDocument(document1);
    assert_(Utils.equals(user1.getBalance(), 0L));
    assert_(Utils.equals(printer.black_remaining, 94L));
    assert_(Utils.equals(printer.sheets_remaining, 94L));
  }

  private void testPrintColorDocument() {

    document1 = user1.createColorDocument(10L, "title_pb");
    user1.addToBalance(90L);
    printer.printColorDocument(document1);
    assert_(Utils.equals(user1.getBalance(), 0L));
    assert_(Utils.equals(printer.black_remaining, 90L));
    assert_(Utils.equals(printer.cyan_remaining, 90L));
    assert_(Utils.equals(printer.yellow_remaining, 90L));
    assert_(Utils.equals(printer.magenta_remaining, 90L));
    assert_(Utils.equals(printer.sheets_remaining, 90L));
  }

  private void testPrintDocument() {

    user1.addToBalance(102L);
    document1 = user1.createBlackDocument(6L, "title_pb");
    printer.printDocument(document1);
    assert_(Utils.equals(printer.black_remaining, 94L));
    assert_(Utils.equals(printer.sheets_remaining, 94L));
    assert_(Utils.equals(user1.getBalance(), 72L));
    document1 = user1.createColorDocument(8L, "title_cor");
    printer.printDocument(document1);
    assert_(Utils.equals(printer.black_remaining, 86L));
    assert_(Utils.equals(printer.sheets_remaining, 86L));
    assert_(Utils.equals(printer.cyan_remaining, 92L));
    assert_(Utils.equals(printer.yellow_remaining, 92L));
    assert_(Utils.equals(printer.magenta_remaining, 92L));
    assert_(Utils.equals(user1.getBalance(), 0L));
  }

  private void testCreateProblem() {

    user1.addToBalance(455L);
    document1 = user1.createBlackDocument(91L, "title_pb");
    printer.printDocument(document1);
    employee = printer.client.company.getEmployee("Joao");
    assert_(Utils.equals(employee.getNumProblems(), 1L));
  }

  public static void main() {

    new PrinterTests().testFunctionalPrinter();
    new PrinterTests().testHasBlack();
    new PrinterTests().testHasColor();
    new PrinterTests().testHaveNoUserLogged();
    new PrinterTests().testLogin();
    new PrinterTests().testLogout();
    new PrinterTests().testPossiblePrintBlackDocument();
    new PrinterTests().testPossiblePrintColorDocument();
    new PrinterTests().testPrintBlackDocument();
    new PrinterTests().testPrintColorDocument();
    new PrinterTests().testPrintDocument();
    new PrinterTests().testCreateProblem();
  }

  public PrinterTests() {}

  public String toString() {

    return "PrinterTests{"
        + "company := "
        + Utils.toString(company)
        + ", client := "
        + Utils.toString(client)
        + ", printer := "
        + Utils.toString(printer)
        + ", user1 := "
        + Utils.toString(user1)
        + ", user2 := "
        + Utils.toString(user2)
        + ", document1 := "
        + Utils.toString(document1)
        + ", employee := "
        + Utils.toString(employee)
        + "}";
  }
}
