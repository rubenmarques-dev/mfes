
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ClientTests extends Tests {
  private Client client = new Client("Ruben", "povoa", quotes.Type1Quote.getInstance());
  private Client client2 = new Client("Pedro", "porto", quotes.Type1Quote.getInstance());
  private User user1 = new User("Username1", "password", client, quotes.Type1Quote.getInstance());
  private User user2 = new User("Username2", "password", client, quotes.Type1Quote.getInstance());
  private Printer printer1 = new Printer("Escritório");
  private Printer printer2 = new Printer("Recepcao");

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

  public static void main() {

    new ClientTests().testClient();
    new ClientTests().addUser();
    new ClientTests().removeUser();
    new ClientTests().addPrinter();
    new ClientTests().removePrinter();
    new ClientTests().sameClient();
    new ClientTests().differenteClient();
    new ClientTests().testGetFreePrinter();
  }

  public ClientTests() {}

  public String toString() {

    return "ClientTests{"
        + "client := "
        + Utils.toString(client)
        + ", client2 := "
        + Utils.toString(client2)
        + ", user1 := "
        + Utils.toString(user1)
        + ", user2 := "
        + Utils.toString(user2)
        + ", printer1 := "
        + Utils.toString(printer1)
        + ", printer2 := "
        + Utils.toString(printer2)
        + "}";
  }
}
