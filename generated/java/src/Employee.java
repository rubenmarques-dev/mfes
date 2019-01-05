
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Employee {
  public String name;
  private VDMSet problems;

  public void cg_init_Employee_1(final String nameC) {

    name = nameC;
    problems = SetUtil.set();
  }

  public Employee(final String nameC) {

    cg_init_Employee_1(nameC);
  }

  public void addProblem(final Problem problem) {

    problems = SetUtil.union(Utils.copy(problems), SetUtil.set(problem));
  }

  public void removeProblem(final Problem problem) {

    for (Iterator iterator_28 = problems.iterator(); iterator_28.hasNext(); ) {
      Problem currentProblem = (Problem) iterator_28.next();
      if (Problem.cg_equals(currentProblem, problem)) {
        problems = SetUtil.diff(Utils.copy(problems), SetUtil.set(currentProblem));
      }
    }
  }

  public Number getNumProblems() {

    return problems.size();
  }

  public Employee() {}

  public static Boolean cg_equals(final Employee employee1, final Employee employee2) {

    return Utils.equals(employee1.name, employee2.name);
  }

  public String toString() {

    return "Employee{"
        + "name := "
        + Utils.toString(name)
        + ", problems := "
        + Utils.toString(problems)
        + "}";
  }
}
