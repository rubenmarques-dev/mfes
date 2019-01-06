
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Document {
  public Number num_sheets;
  public String type;
  public String title;
  public Number price = 1L;
  private TypeDocument typeDocument = new TypeDocument();
  public User user;

  public void cg_init_Document_1(
      final Number numSheetsC, final String typeC, final String titleC, final User userC) {

    num_sheets = numSheetsC;
    price = typeDocument.getPrice(typeC);
    title = titleC;
    type = typeC;
    user = userC;
    user.addDocument(this);
  }

  public Document(
      final Number numSheetsC, final String typeC, final String titleC, final User userC) {

    cg_init_Document_1(numSheetsC, typeC, titleC, userC);
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

  public static Boolean cg_equals(final Document d1, final Document d2) {

    Boolean andResult_2 = false;

    if (Utils.equals(d1.type, d2.type)) {
      Boolean andResult_3 = false;

      if (Utils.equals(d1.title, d2.title)) {
        if (Utils.equals(d1.num_sheets, d2.num_sheets)) {
          andResult_3 = true;
        }
      }

      if (andResult_3) {
        andResult_2 = true;
      }
    }

    return andResult_2;
  }

  public String toString() {

    return "Document{"
        + "num_sheets := "
        + Utils.toString(num_sheets)
        + ", type := "
        + Utils.toString(type)
        + ", title := "
        + Utils.toString(title)
        + ", price := "
        + Utils.toString(price)
        + ", typeDocument := "
        + Utils.toString(typeDocument)
        + "}";
  }
}
