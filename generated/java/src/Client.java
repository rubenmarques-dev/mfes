
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Client {
  public String name;
  public String location;
  private VDMSet users;
  private VDMSet printers;
  public Company company = null;

  public void cg_init_Client_1(final String nameC, final String locationC, final Company companyC) {

    name = nameC;
    location = locationC;
    users = SetUtil.set();
    printers = SetUtil.set();
    company = companyC;
    company.addClient(this);
  }

  public Client(final String nameC, final String locationC, final Company companyC) {

    cg_init_Client_1(nameC, locationC, companyC);
  }

  public VDMSet getUsers() {

    return Utils.copy(users);
  }

  public void addUser(final User user) {

    users = SetUtil.union(Utils.copy(users), SetUtil.set(user));
  }

  public void removeUser(final User user) {

    for (Iterator iterator_19 = users.iterator(); iterator_19.hasNext(); ) {
      User currentUser = (User) iterator_19.next();
      if (User.cg_equals(currentUser, user)) {
        users = SetUtil.diff(Utils.copy(users), SetUtil.set(currentUser));
      }
    }
  }

  public User getUser(final String username) {

    User user = null;
    for (Iterator iterator_20 = users.iterator(); iterator_20.hasNext(); ) {
      User current = (User) iterator_20.next();
      if (Utils.equals(current.username, username)) {
        user = current;
      }
    }
    return user;
  }

  public Printer getPrinter(final String location_1) {

    Printer printer = null;
    for (Iterator iterator_21 = printers.iterator(); iterator_21.hasNext(); ) {
      Printer current = (Printer) iterator_21.next();
      if (Utils.equals(current.location, location_1)) {
        printer = current;
      }
    }
    return printer;
  }

  public VDMSet getPrinters() {

    return Utils.copy(printers);
  }

  public void addPrinter(final Printer printer) {

    printers = SetUtil.union(Utils.copy(printers), SetUtil.set(printer));
  }

  public void removePrinter(final Printer printer) {

    for (Iterator iterator_22 = printers.iterator(); iterator_22.hasNext(); ) {
      Printer currentPrinter = (Printer) iterator_22.next();
      if (Printer.cg_equals(currentPrinter, printer)) {
        printers = SetUtil.diff(Utils.copy(printers), SetUtil.set(currentPrinter));
      }
    }
  }

  public Printer getFreePrinter() {

    VDMSeq freePrinters = SeqUtil.seq();
    for (Iterator iterator_23 = printers.iterator(); iterator_23.hasNext(); ) {
      Printer currentPrinter = (Printer) iterator_23.next();
      Boolean andResult_1 = false;

      if (Utils.equals(currentPrinter.isFree(), true)) {
        if (Utils.equals(currentPrinter.functional, true)) {
          andResult_1 = true;
        }
      }

      if (andResult_1) {
        freePrinters = SeqUtil.conc(Utils.copy(freePrinters), SeqUtil.seq(currentPrinter));
      }
    }
    if (Utils.equals(freePrinters.size(), 0L)) {
      return null;

    } else {
      return ((Printer) freePrinters.get(0));
    }
  }

  public VDMSet getNoFunctionalPrinters() {

    VDMSet noFunctionalPrinters = SetUtil.set();
    for (Iterator iterator_24 = printers.iterator(); iterator_24.hasNext(); ) {
      Printer currentPrinter = (Printer) iterator_24.next();
      if (Utils.equals(currentPrinter.functional, false)) {
        noFunctionalPrinters =
            SetUtil.union(Utils.copy(noFunctionalPrinters), SetUtil.set(currentPrinter));
      }
    }
    return Utils.copy(noFunctionalPrinters);
  }

  public Client() {}

  public static Boolean cg_equals(final Client c1, final Client c2) {

    Boolean andResult_2 = false;

    if (Utils.equals(c1.name, c2.name)) {
      if (Utils.equals(c1.location, c2.location)) {
        andResult_2 = true;
      }
    }

    return andResult_2;
  }

  public String toString() {

    return "Client{"
        + "name := "
        + Utils.toString(name)
        + ", location := "
        + Utils.toString(location)
        + ", users := "
        + Utils.toString(users)
        + ", printers := "
        + Utils.toString(printers)
        + "}";
  }
}
