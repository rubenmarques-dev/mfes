
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ClientTests extends Tests {
  private Company company = new Company();
  private Client clientEmpty = new Client("Empty", "povoa", company);
  private Client client = new Client("Ruben", "povoa", company);
  private Client client2 = new Client("Pedro", "porto", company);
  private User user1 = new User("Username1", "password", client);
  private User user2 = new User("Username2", "password", client);
  private User userAux = null;
  private Printer printer1 = new Printer("FEUP", client);
  private Printer printer2 = new Printer("Recepcao", client);
  private Printer printerAux = null;
  private VDMSet printers = SetUtil.set();

  private void testClient() {

    assert_(Utils.equals(client.getUsers().size(), 2L));
    assert_(Utils.equals(client.getPrinters().size(), 2L));
    assert_(Utils.equals(clientEmpty.getUsers().size(), 0L));
    assert_(Utils.equals(clientEmpty.getPrinters().size(), 0L));
    assert_(Utils.empty(clientEmpty.getUsers()));
    assert_(Utils.empty(clientEmpty.getPrinters()));
  }

  private void addUser() {

    client2.addUser(user1);
    assert_(SetUtil.inSet(user1, client2.getUsers()));
  }

  private void removeUser() {

    client.removeUser(user1);
    assert_(!(SetUtil.inSet(user1, client.getUsers())));
  }

  private void sameClient() {

    assert_(Client.cg_equals(client, client));
  }

  private void differenteClient() {

    assert_(!(Client.cg_equals(client, client2)));
  }

  private void addPrinter() {

    client2.addPrinter(printer1);
    assert_(SetUtil.inSet(printer1, client2.getPrinters()));
  }

  private void removePrinter() {

    client.removePrinter(printer1);
    assert_(!(SetUtil.inSet(printer1, client.getPrinters())));
  }

  private void testGetFreePrinter() {

    printer1.login(user1);
    assert_(Utils.equals(client.getFreePrinter(), printer2));
  }

  private void testGetUser() {

    userAux = client.getUser(user1.username);
    assert_(Utils.equals(userAux, user1));
  }

  private void testGetPrinter() {

    printerAux = client.getPrinter(printer1.location);
    assert_(Utils.equals(printerAux, printer1));
  }

  private void testGetNoFunctionalPrinters() {

    printer1.functional = false;
    printers = client.getNoFunctionalPrinters();
    assert_(SetUtil.inSet(printer1, printers));
    printer2.functional = false;
    printers = client.getNoFunctionalPrinters();
    assert_(SetUtil.inSet(printer1, printers));
    assert_(SetUtil.inSet(printer2, printers));
  }

  public static void main() {

    new ClientTests().testClient();
    new ClientTests().addUser();
    new ClientTests().removeUser();
    new ClientTests().addPrinter();
    new ClientTests().removePrinter();
    new ClientTests().sameClient();
    new ClientTests().differenteClient();
    new ClientTests().testGetFreePrinter();
    new ClientTests().testGetUser();
    new ClientTests().testGetPrinter();
    new ClientTests().testGetNoFunctionalPrinters();
  }

  public ClientTests() {}

  public String toString() {

    return "ClientTests{"
        + "company := "
        + Utils.toString(company)
        + ", clientEmpty := "
        + Utils.toString(clientEmpty)
        + ", client := "
        + Utils.toString(client)
        + ", client2 := "
        + Utils.toString(client2)
        + ", user1 := "
        + Utils.toString(user1)
        + ", user2 := "
        + Utils.toString(user2)
        + ", userAux := "
        + Utils.toString(userAux)
        + ", printer1 := "
        + Utils.toString(printer1)
        + ", printer2 := "
        + Utils.toString(printer2)
        + ", printerAux := "
        + Utils.toString(printerAux)
        + ", printers := "
        + Utils.toString(printers)
        + "}";
  }
}
