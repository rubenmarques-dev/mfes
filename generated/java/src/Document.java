
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Document {
  private Number num_sheets;
  private String type;
  private Number price = 1L;
  private TypeDocument typeDocument = new TypeDocument();
  private User user;

  public void cg_init_Document_1(final Number numSheetsC, final String typeC, final User userC) {

    num_sheets = numSheetsC;
    price = typeDocument.getPrice(typeC);
    type = typeC;
    user = userC;
  }

  public Document(final Number numSheetsC, final String typeC, final User userC) {

    cg_init_Document_1(numSheetsC, typeC, userC);
  }

  public String getType() {

    return type;
  }

  public Number getTotalPrice() {

    return num_sheets.longValue() * price.longValue();
  }

  public Number getNumSheets() {

    return num_sheets;
  }

  public User getUser() {

    return user;
  }

  public Document() {}

  public String toString() {

    return "Document{"
        + "num_sheets := "
        + Utils.toString(num_sheets)
        + ", type := "
        + Utils.toString(type)
        + ", price := "
        + Utils.toString(price)
        + ", typeDocument := "
        + Utils.toString(typeDocument)
        + ", user := "
        + Utils.toString(user)
        + "}";
  }
}
