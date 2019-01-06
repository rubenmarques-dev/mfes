
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class EmployeeTests extends Tests {
  private Company company = new Company();
  private Client client = new Client("Ruben", "povoa", company);
  private Printer printer = new Printer("FEUP", client);
  private Printer printer2 = new Printer("Fep", client);
  private Employee employee = new Employee("Joao");
  private Problem problem1 = null;
  private Problem problem2 = null;
  private VDMSet problems = SetUtil.set();

  public void testNumProblems() {

    assert_(Utils.equals(employee.getNumProblems(), 0L));
    problem1 = new Problem("descricao", printer, employee);
    assert_(Utils.equals(employee.getNumProblems(), 1L));
    problem2 = new Problem("descricao1", printer2, employee);
    assert_(Utils.equals(employee.getNumProblems(), 2L));
    employee.removeProblem(problem2);
    assert_(Utils.equals(employee.getNumProblems(), 1L));
  }

  public void testProblemsToSolve() {

    problem1 = new Problem("descricao", printer, employee);
    problem2 = new Problem("descricao1", printer2, employee);
    problems = employee.getProblemsToSolve();
    assert_(Utils.equals(problems.size(), 2L));
    employee.solveProblem(problem1);
    problems = employee.getProblemsToSolve();
    assert_(Utils.equals(problems.size(), 1L));
    problems = employee.getProblemsSolved();
    assert_(Utils.equals(problems.size(), 1L));
    assert_(SetUtil.inSet(problem1, problems));
  }

  public static void main() {

    new EmployeeTests().testNumProblems();
    new EmployeeTests().testProblemsToSolve();
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
        + ", printer2 := "
        + Utils.toString(printer2)
        + ", employee := "
        + Utils.toString(employee)
        + ", problem1 := "
        + Utils.toString(problem1)
        + ", problem2 := "
        + Utils.toString(problem2)
        + ", problems := "
        + Utils.toString(problems)
        + "}";
  }
}
