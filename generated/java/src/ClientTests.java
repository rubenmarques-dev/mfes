
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ClientTests extends Tests {
  private Company company = new Company();
  private Client client = new Client("Ruben", "povoa", company);
  private Client client2 = new Client("Pedro", "porto", company);
  private User user1 = new User("Username1", "password", client);
  private User user2 = new User("Username2", "password", client);
  private User userAux = null;
  private Printer printer1 = new Printer("FEUP", client);
  private Printer printer2 = new Printer("Recepcao", client);
  private Printer printerAux = null;

  private void testClient() {

    assert_(Utils.empty(client.getUsers()));
    assert_(Utils.empty(client.getPrinters()));
  }

  private void addUser() {

    client.addUser(user1);
    assert_(SetUtil.inSet(user1, client.getUsers()));
  }

  private void removeUser() {

    client.addUser(user1);
    assert_(SetUtil.inSet(user1, client.getUsers()));
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

    client.addPrinter(printer1);
    assert_(SetUtil.inSet(printer1, client.getPrinters()));
  }

  private void removePrinter() {

    client.addPrinter(printer1);
    assert_(SetUtil.inSet(printer1, client.getPrinters()));
    client.removePrinter(printer1);
    assert_(!(SetUtil.inSet(printer1, client.getPrinters())));
  }

  private void testGetFreePrinter() {

    printer1.login(user1);
    client.addPrinter(printer1);
    client.addPrinter(printer2);
    assert_(Utils.equals(client.getFreePrinter(), printer2));
  }

  private void testGetUser() {

    client.addUser(user1);
    assert_(SetUtil.inSet(user1, client.getUsers()));
    userAux = client.getUser(user1.username);
    assert_(Utils.equals(userAux, user1));
  }

  private void testGetPrinter() {

    client.addPrinter(printer1);
    assert_(SetUtil.inSet(printer1, client.getPrinters()));
    printerAux = client.getPrinter(printer1.location);
    assert_(Utils.equals(printerAux, printer1));
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
  }

  public ClientTests() {}

  public String toString() {

    return "ClientTests{"
        + "company := "
        + Utils.toString(company)
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
        + "}";
  }
}
