
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class User {
  private String username;
  private String password;
  private Object type;
  private Number balance;
  private VDMSeq documents;
  private Client client;

  public void cg_init_User_1(
      final String usernameC, final String passwordC, final Client clientC, final Object typeC) {

    username = usernameC;
    password = passwordC;
    type = typeC;
    balance = 0L;
    client = clientC;
    documents = SeqUtil.seq();
  }

  public User(
      final String usernameC, final String passwordC, final Client clientC, final Object typeC) {

    cg_init_User_1(usernameC, passwordC, clientC, typeC);
  }

  public VDMSeq getDocuments() {

    return Utils.copy(documents);
  }

  public Document createBlackDocument(final Number num_sheets) {

    Document document = null;
    document = new Document(num_sheets, "PB", this);
    addDocument(document);
    return document;
  }

  public Document createColorDocument(final Number num_sheets) {

    Document document = null;
    document = new Document(num_sheets, "Cor", this);
    addDocument(document);
    return document;
  }

  public void addDocument(final Document document) {

    documents = SeqUtil.conc(SeqUtil.seq(document), Utils.copy(documents));
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
        + ", type := "
        + Utils.toString(type)
        + ", balance := "
        + Utils.toString(balance)
        + ", documents := "
        + Utils.toString(documents)
        + ", client := "
        + Utils.toString(client)
        + "}";
  }
}
