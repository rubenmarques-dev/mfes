
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Printer {
  public String location;
  public Number sheets_remaining;
  public Number black_remaining;
  public Number cyan_remaining;
  public Number yellow_remaining;
  public Number magenta_remaining;
  public Boolean functional;
  public User user = null;

  public void cg_init_Printer_1(final String locationC) {

    location = locationC;
    sheets_remaining = 100L;
    black_remaining = 100L;
    cyan_remaining = 100L;
    yellow_remaining = 100L;
    magenta_remaining = 100L;
    functional = true;
  }

  public Printer(final String locationC) {

    cg_init_Printer_1(locationC);
  }

  public Boolean checkValidPrintBlack(final Number sheets) {

    Boolean andResult_2 = false;

    if (black_remaining.longValue() >= sheets.longValue()) {
      if (sheets_remaining.longValue() >= sheets.longValue()) {
        andResult_2 = true;
      }
    }

    return andResult_2;
  }

  public Boolean checkValidPrintColor(final Number sheets) {

    Boolean andResult_3 = false;

    if (black_remaining.longValue() >= sheets.longValue()) {
      Boolean andResult_4 = false;

      if (cyan_remaining.longValue() >= sheets.longValue()) {
        Boolean andResult_5 = false;

        if (yellow_remaining.longValue() >= sheets.longValue()) {
          Boolean andResult_6 = false;

          if (magenta_remaining.longValue() >= sheets.longValue()) {
            if (sheets_remaining.longValue() >= sheets.longValue()) {
              andResult_6 = true;
            }
          }

          if (andResult_6) {
            andResult_5 = true;
          }
        }

        if (andResult_5) {
          andResult_4 = true;
        }
      }

      if (andResult_4) {
        andResult_3 = true;
      }
    }

    return andResult_3;
  }

  public Boolean checkFunctionalPrinter() {

    return Utils.equals(functional, true);
  }

  public void login(final User u) {

    User ternaryIfExp_1 = null;

    if (Utils.equals(user, null)) {
      ternaryIfExp_1 = u;
    } else {
      ternaryIfExp_1 = user;
    }

    user = ternaryIfExp_1;
  }

  public User getUserLogged() {

    return user;
  }

  public void logout() {

    user = null;
  }

  public Boolean isFree() {

    return Utils.equals(user, null);
  }

  public Boolean possiblePrintBlackDocument(final Document document) {

    Boolean andResult_7 = false;

    if (document.getTotalPrice().longValue() <= document.getUser().getBalance().longValue()) {
      Boolean andResult_8 = false;

      if (checkValidPrintBlack(document.getNumSheets())) {
        Boolean andResult_9 = false;

        if (functional) {
          if (Utils.equals(user, document.getUser())) {
            andResult_9 = true;
          }
        }

        if (andResult_9) {
          andResult_8 = true;
        }
      }

      if (andResult_8) {
        andResult_7 = true;
      }
    }

    return andResult_7;
  }

  public Printer() {}

  public static Boolean cg_equals(final Printer printer1, final Printer printer2) {

    return Utils.equals(printer1.location, printer2.location);
  }

  public String toString() {

    return "Printer{"
        + "location := "
        + Utils.toString(location)
        + ", sheets_remaining := "
        + Utils.toString(sheets_remaining)
        + ", black_remaining := "
        + Utils.toString(black_remaining)
        + ", cyan_remaining := "
        + Utils.toString(cyan_remaining)
        + ", yellow_remaining := "
        + Utils.toString(yellow_remaining)
        + ", magenta_remaining := "
        + Utils.toString(magenta_remaining)
        + ", functional := "
        + Utils.toString(functional)
        + ", user := "
        + Utils.toString(user)
        + "}";
  }
}
