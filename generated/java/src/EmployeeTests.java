
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class EmployeeTests extends Tests {
  private Company company = new Company();
  private Client client = new Client("Ruben", "povoa", company);
  private Printer printer = new Printer("FEUP", client);
  private Employee employee = new Employee("Joao");
  private Problem problem1 = new Problem("descricao", printer);
  private Problem problem2 = new Problem("descricao2", printer);

  public void testNumProblems() {

    assert_(Utils.equals(employee.getNumProblems(), 0L));
    employee.addProblem(problem1);
    assert_(Utils.equals(employee.getNumProblems(), 1L));
    employee.addProblem(problem2);
    assert_(Utils.equals(employee.getNumProblems(), 2L));
    employee.removeProblem(problem2);
    assert_(Utils.equals(employee.getNumProblems(), 1L));
  }

  public static void main() {

    new EmployeeTests().testNumProblems();
  }

  public EmployeeTests() {}

  public String toString() {

    return "EmployeeTests{"
        + "company := "
        + Utils.toString(company)
        + ", client := "
        + Utils.toString(client)
        + ", printer := "
        + Utils.toString(printer)
        + ", employee := "
        + Utils.toString(employee)
        + ", problem1 := "
        + Utils.toString(problem1)
        + ", problem2 := "
        + Utils.toString(problem2)
        + "}";
  }
}
