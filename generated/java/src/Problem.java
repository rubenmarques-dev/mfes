
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
