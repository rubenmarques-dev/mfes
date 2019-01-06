
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Employee {
  public String name;
  public VDMSet problems;

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

    for (Iterator iterator_30 = problems.iterator(); iterator_30.hasNext(); ) {
      Problem currentProblem = (Problem) iterator_30.next();
      if (Problem.cg_equals(currentProblem, problem)) {
        problems = SetUtil.diff(Utils.copy(problems), SetUtil.set(currentProblem));
      }
    }
  }

  public VDMSet getProblemsToSolve() {

    VDMSet problemsToSolve = SetUtil.set();
    for (Iterator iterator_31 = problems.iterator(); iterator_31.hasNext(); ) {
      Problem current = (Problem) iterator_31.next();
      if (Utils.equals(current.solved, false)) {
        problemsToSolve = SetUtil.union(Utils.copy(problemsToSolve), SetUtil.set(current));
      }
    }
    return Utils.copy(problemsToSolve);
  }

  public VDMSet getProblemsSolved() {

    VDMSet problemsToSolve = SetUtil.set();
    for (Iterator iterator_32 = problems.iterator(); iterator_32.hasNext(); ) {
      Problem current = (Problem) iterator_32.next();
      if (Utils.equals(current.solved, true)) {
        problemsToSolve = SetUtil.union(Utils.copy(problemsToSolve), SetUtil.set(current));
      }
    }
    return Utils.copy(problemsToSolve);
  }

  public Number getNumProblems() {

    return problems.size();
  }

  public void solveProblem(final Problem problem) {

    problem.printer.fullRepair();
    problem.solveIt();
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
