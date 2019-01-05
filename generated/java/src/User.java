
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
    addDocument(document);
    return document;
  }

  public Document createColorDocument(final Number num_sheets, final String title) {

    Document document = null;
    document = new Document(num_sheets, "Cor", title, this);
    addDocument(document);
    return document;
  }

  public void addDocument(final Document document) {

    documents = SetUtil.union(Utils.copy(documents), SetUtil.set(document));
  }

  public void removeDocument(final Document document) {

    for (Iterator iterator_29 = documents.iterator(); iterator_29.hasNext(); ) {
      Document curentDocument = (Document) iterator_29.next();
      if (Document.cg_equals(curentDocument, document)) {
        documents = SetUtil.diff(Utils.copy(documents), SetUtil.set(curentDocument));
      }
    }
  }

  public Boolean hasDocument(final Document document) {

    return SetUtil.inSet(document, documents);
  }

  public void addToBalance(final Number amount) {

    balance = balance.longValue() + amount.longValue();
  }

  public void withdrawFromBalance(final Number amount) {

    balance = balance.longValue() - amount.longValue();
  }

  public User getUser() {

    return this;
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
        + ", client := "
        + Utils.toString(client)
        + "}";
  }
}
