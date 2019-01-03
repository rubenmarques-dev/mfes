
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Employee {
  private String name;
  private VDMSet problems;

  public void cg_init_Employee_1(final String nameC) {

    name = nameC;
    problems = SetUtil.set();
  }

  public Employee(final String nameC) {

    cg_init_Employee_1(nameC);
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
