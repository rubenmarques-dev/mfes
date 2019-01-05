
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ProblemTests extends Tests {
  private Company company = new Company();
  private Client client = new Client("Ruben", "povoa", company);
  private Printer printer = new Printer("FEUP", client);
  private Printer printer2 = new Printer("FEP", client);
  private Employee employee = new Employee("Joao");
  private Problem problem1 = new Problem("problem1", printer, employee);
  private Problem problem2 = new Problem("problem2", printer2, employee);

  public void twoProblemsUnsolved() {

    assert_(Utils.equals(Problem.twoProblemsUnsolved(problem1, problem2), false));
  }

  public void cg_equals() {

    assert_(Utils.equals(Problem.cg_equals(problem1, problem2), false));
  }

  public static void main() {

    new ProblemTests().twoProblemsUnsolved();
    new ProblemTests().cg_equals();
  }

  public ProblemTests() {}

  public String toString() {

    return "ProblemTests{"
        + "company := "
        + Utils.toString(company)
        + ", client := "
        + Utils.toString(client)
        + ", printer := "
        + Utils.toString(printer)
        + ", printer2 := "
        + Utils.toString(printer2)
        + ", employee := "
        + Utils.toString(employee)
        + ", problem1 := "
        + Utils.toString(problem1)
        + ", problem2 := "
        + Utils.toString(problem2)
        + "}";
  }
}
