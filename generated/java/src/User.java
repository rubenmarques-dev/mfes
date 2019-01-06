
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class User {
  public String username;
  private String password;
  private Number balance;
  private VDMSet documents;
  private Client client;

  public void cg_init_User_1(final String usernameC, final String passwordC, final Client clientC) {

    username = usernameC;
    password = passwordC;
    balance = 0L;
    client = clientC;
    documents = SetUtil.set();
    client.addUser(this);
  }

  public User(final String usernameC, final String passwordC, final Client clientC) {

    cg_init_User_1(usernameC, passwordC, clientC);
  }

  public VDMSet getDocuments() {

    return Utils.copy(documents);
  }

  public Document createBlackDocument(final Number num_sheets, final String title) {

    Document document = null;
    document = new Document(num_sheets, "PB", title, this);
    return document;
  }

  public Document createColorDocument(final Number num_sheets, final String title) {

    Document document = null;
    document = new Document(num_sheets, "Cor", title, this);
    return document;
  }

  public void addDocument(final Document document) {

    documents = SetUtil.union(Utils.copy(documents), SetUtil.set(document));
  }

  public void removeDocument(final Document document) {

    for (Iterator iterator_31 = documents.iterator(); iterator_31.hasNext(); ) {
      Document curentDocument = (Document) iterator_31.next();
      if (Document.cg_equals(curentDocument, document)) {
        documents = SetUtil.diff(Utils.copy(documents), SetUtil.set(curentDocument));
      }
    }
  }

  public Boolean hasDocument(final Document document) {

    return SetUtil.inSet(document, documents);
  }

  public Document getDocument(final String title, final Number num_sheets) {

    Document document = null;
    for (Iterator iterator_32 = documents.iterator(); iterator_32.hasNext(); ) {
      Document current = (Document) iterator_32.next();
      Boolean andResult_28 = false;

      if (Utils.equals(current.title, title)) {
        if (Utils.equals(current.num_sheets, num_sheets)) {
          andResult_28 = true;
        }
      }

      if (andResult_28) {
        document = current;
      }
    }
    return document;
  }

  public void addToBalance(final Number amount) {

    balance = balance.longValue() + amount.longValue();
  }

  public void withdrawFromBalance(final Number amount) {

    balance = balance.longValue() - amount.longValue();
  }

  public String getUsername() {

    return username;
  }

  public String getPassword() {

    return password;
  }

  public Number getBalance() {

    return balance;
  }

  public Boolean enoughBalance(final Number amount) {

    return balance.longValue() >= amount.longValue();
  }

  public Printer loginToPrinter() {

    Printer printer = null;
    printer = null;
    printer = client.getFreePrinter();
    return printer;
  }

  public User() {}

  public static Boolean cg_equals(final User user1, final User user2) {

    return Utils.equals(user1.username, user2.username);
  }

  public String toString() {

    return "User{"
        + "username := "
        + Utils.toString(username)
        + ", password := "
        + Utils.toString(password)
        + ", balance := "
        + Utils.toString(balance)
        + ", documents := "
        + Utils.toString(documents)
        + "}";
  }
}
