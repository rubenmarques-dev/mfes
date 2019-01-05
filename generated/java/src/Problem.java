
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Problem {
  private String description;
  private Boolean solved;
  private Printer printer;

  public void cg_init_Problem_1(final String descriptionC, final Printer printerC) {

    description = descriptionC;
    printer = printerC;
    solved = false;
  }

  public Problem(final String descriptionC, final Printer printerC) {

    cg_init_Problem_1(descriptionC, printerC);
  }

  public Problem() {}

  public static Boolean cg_equals(final Problem p1, final Problem p2) {

    Boolean andResult_17 = false;

    if (Utils.equals(p1.description, p2.description)) {
      Boolean andResult_18 = false;

      if (Utils.equals(p1.printer, p2.printer)) {
        if (Utils.equals(p1.solved, p2.solved)) {
          andResult_18 = true;
        }
      }

      if (andResult_18) {
        andResult_17 = true;
      }
    }

    return andResult_17;
  }

  public String toString() {

    return "Problem{"
        + "description := "
        + Utils.toString(description)
        + ", solved := "
        + Utils.toString(solved)
        + ", printer := "
        + Utils.toString(printer)
        + "}";
  }
}
