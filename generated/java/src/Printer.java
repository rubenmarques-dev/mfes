
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
  public User userLogged = null;
  public Client client;

  public void cg_init_Printer_1(final String locationC, final Client clientC) {

    location = locationC;
    sheets_remaining = 100L;
    black_remaining = 100L;
    cyan_remaining = 100L;
    yellow_remaining = 100L;
    magenta_remaining = 100L;
    functional = true;
    client = clientC;
    client.addPrinter(this);
  }

  public Printer(final String locationC, final Client clientC) {

    cg_init_Printer_1(locationC, clientC);
  }

  public Boolean checkValidPrintBlack(final Number sheets) {

    Boolean andResult_4 = false;

    if (black_remaining.longValue() >= sheets.longValue()) {
      if (sheets_remaining.longValue() >= sheets.longValue()) {
        andResult_4 = true;
      }
    }

    return andResult_4;
  }

  public Boolean checkValidPrintColor(final Number sheets) {

    Boolean andResult_5 = false;

    if (black_remaining.longValue() >= sheets.longValue()) {
      Boolean andResult_6 = false;

      if (cyan_remaining.longValue() >= sheets.longValue()) {
        Boolean andResult_7 = false;

        if (yellow_remaining.longValue() >= sheets.longValue()) {
          Boolean andResult_8 = false;

          if (magenta_remaining.longValue() >= sheets.longValue()) {
            if (sheets_remaining.longValue() >= sheets.longValue()) {
              andResult_8 = true;
            }
          }

          if (andResult_8) {
            andResult_7 = true;
          }
        }

        if (andResult_7) {
          andResult_6 = true;
        }
      }

      if (andResult_6) {
        andResult_5 = true;
      }
    }

    return andResult_5;
  }

  public Boolean checkFunctionalPrinter() {

    return Utils.equals(functional, true);
  }

  public void login(final User u) {

    User ternaryIfExp_1 = null;

    if (Utils.equals(userLogged, null)) {
      ternaryIfExp_1 = u;
    } else {
      ternaryIfExp_1 = userLogged;
    }

    userLogged = ternaryIfExp_1;
  }

  public User getUserLogged() {

    return userLogged;
  }

  public void logout() {

    userLogged = null;
  }

  public Boolean isFree() {

    return Utils.equals(userLogged, null);
  }

  public Boolean possiblePrintBlackDocument(final Document document) {

    Boolean andResult_9 = false;

    if (document.getTotalPrice().longValue() <= document.getUser().getBalance().longValue()) {
      Boolean andResult_10 = false;

      if (checkValidPrintBlack(document.getNumSheets())) {
        Boolean andResult_11 = false;

        if (functional) {
          if (Utils.equals(userLogged, document.getUser())) {
            andResult_11 = true;
          }
        }

        if (andResult_11) {
          andResult_10 = true;
        }
      }

      if (andResult_10) {
        andResult_9 = true;
      }
    }

    return andResult_9;
  }

  public Boolean possiblePrintColorDocument(final Document document) {

    Boolean andResult_12 = false;

    if (document.getTotalPrice().longValue() <= document.getUser().getBalance().longValue()) {
      Boolean andResult_13 = false;

      if (checkValidPrintColor(document.getNumSheets())) {
        Boolean andResult_14 = false;

        if (functional) {
          if (Utils.equals(userLogged, document.getUser())) {
            andResult_14 = true;
          }
        }

        if (andResult_14) {
          andResult_13 = true;
        }
      }

      if (andResult_13) {
        andResult_12 = true;
      }
    }

    return andResult_12;
  }

  public void printDocument(final Document document) {

    {
      if (Utils.equals(document.getType(), "PB")) {
        printBlackDocument(document);
      } else {
        printColorDocument(document);
      }
    }

    stillFunctional();
  }

  public void printBlackDocument(final Document document) {

    sheets_remaining = sheets_remaining.longValue() - document.getNumSheets().longValue();
    black_remaining = black_remaining.longValue() - document.getNumSheets().longValue();
    document.getUser().withdrawFromBalance(document.getTotalPrice());
  }

  public void printColorDocument(final Document document) {

    sheets_remaining = sheets_remaining.longValue() - document.getNumSheets().longValue();
    black_remaining = black_remaining.longValue() - document.getNumSheets().longValue();
    cyan_remaining = cyan_remaining.longValue() - document.getNumSheets().longValue();
    yellow_remaining = yellow_remaining.longValue() - document.getNumSheets().longValue();
    magenta_remaining = magenta_remaining.longValue() - document.getNumSheets().longValue();
    document.getUser().withdrawFromBalance(document.getTotalPrice());
  }

  public void stillFunctional() {

    Boolean orResult_5 = false;

    if (sheets_remaining.longValue() < 10L) {
      orResult_5 = true;
    } else {
      Boolean orResult_6 = false;

      if (black_remaining.longValue() < 10L) {
        orResult_6 = true;
      } else {
        Boolean orResult_7 = false;

        if (cyan_remaining.longValue() < 10L) {
          orResult_7 = true;
        } else {
          Boolean orResult_8 = false;

          if (yellow_remaining.longValue() < 10L) {
            orResult_8 = true;
          } else {
            orResult_8 = magenta_remaining.longValue() < 10L;
          }

          orResult_7 = orResult_8;
        }

        orResult_6 = orResult_7;
      }

      orResult_5 = orResult_6;
    }

    if (orResult_5) {
      {
        Problem problem = null;
        Employee employee = null;
        employee = client.company.getEmployeeLessBusy();
        problem = new Problem("resources needed", this, employee);
      }
    }
  }

  public void fullRepair() {

    sheets_remaining = 100L;
    black_remaining = 100L;
    cyan_remaining = 100L;
    yellow_remaining = 100L;
    magenta_remaining = 100L;
    functional = true;
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
        + ", userLogged := "
        + Utils.toString(userLogged)
        + ", client := "
        + Utils.toString(client)
        + "}";
  }
}
