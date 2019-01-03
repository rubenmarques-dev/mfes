
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Client {
  private String name;
  private String location;
  private Object type;
  private VDMSet users;
  private VDMSet printers;

  public void cg_init_Client_1(final String nameC, final String locationC, final Object typeC) {

    name = nameC;
    location = locationC;
    type = typeC;
    users = SetUtil.set();
    printers = SetUtil.set();
  }

  public Client(final String nameC, final String locationC, final Object typeC) {

    cg_init_Client_1(nameC, locationC, typeC);
  }

  public VDMSet getUsers() {

    return Utils.copy(users);
  }

  public void addUser(final User user) {

    users = SetUtil.union(Utils.copy(users), SetUtil.set(user));
  }

  public void removeUser(final User user) {

    for (Iterator iterator_13 = users.iterator(); iterator_13.hasNext(); ) {
      User currentUser = (User) iterator_13.next();
      if (User.cg_equals(currentUser, user)) {
        users = SetUtil.diff(Utils.copy(users), SetUtil.set(currentUser));
      }
    }
  }

  public VDMSet getPrinters() {

    return Utils.copy(printers);
  }

  public void addPrinter(final Printer printer) {

    printers = SetUtil.union(Utils.copy(printers), SetUtil.set(printer));
  }

  public void removePrinter(final Printer printer) {

    for (Iterator iterator_14 = printers.iterator(); iterator_14.hasNext(); ) {
      Printer currentPrinter = (Printer) iterator_14.next();
      if (Printer.cg_equals(currentPrinter, printer)) {
        printers = SetUtil.diff(Utils.copy(printers), SetUtil.set(currentPrinter));
      }
    }
  }

  public Printer getFreePrinter() {

    VDMSeq freePrinters = SeqUtil.seq();
    for (Iterator iterator_15 = printers.iterator(); iterator_15.hasNext(); ) {
      Printer currentPrinter = (Printer) iterator_15.next();
      if (Utils.equals(currentPrinter.isFree(), true)) {
        freePrinters = SeqUtil.conc(Utils.copy(freePrinters), SeqUtil.seq(currentPrinter));
      }
    }
    return ((Printer) freePrinters.get(0));
  }

  public Client() {}

  public static Boolean cg_equals(final Client c1, final Client c2) {

    Boolean andResult_1 = false;

    if (Utils.equals(c1.name, c2.name)) {
      if (Utils.equals(c1.location, c2.location)) {
        andResult_1 = true;
      }
    }

    return andResult_1;
  }

  public String toString() {

    return "Client{"
        + "name := "
        + Utils.toString(name)
        + ", location := "
        + Utils.toString(location)
        + ", type := "
        + Utils.toString(type)
        + ", users := "
        + Utils.toString(users)
        + ", printers := "
        + Utils.toString(printers)
        + "}";
  }
}
