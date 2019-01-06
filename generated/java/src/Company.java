
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Company {
  private VDMSet clients;
  private VDMSet employees = SetUtil.set();

  public void cg_init_Company_1() {

    clients = SetUtil.set();
    initiateEmployess();
  }

  public Company() {

    cg_init_Company_1();
  }

  public void initiateEmployess() {

    Employee employee1 = null;
    Employee employee2 = null;
    employee1 = new Employee("Joao");
    employee2 = new Employee("Carlos");
    addEmployee(employee1);
    addEmployee(employee2);
  }

  public VDMSet getClients() {

    return Utils.copy(clients);
  }

  public VDMSet getEmployees() {

    return Utils.copy(employees);
  }

  public void addClient(final Client client) {

    clients = SetUtil.union(Utils.copy(clients), SetUtil.set(client));
  }

  public void removeClient(final Client client) {

    for (Iterator iterator_26 = clients.iterator(); iterator_26.hasNext(); ) {
      Client currentClient = (Client) iterator_26.next();
      if (Client.cg_equals(currentClient, client)) {
        clients = SetUtil.diff(Utils.copy(clients), SetUtil.set(currentClient));
      }
    }
  }

  public void addEmployee(final Employee employee) {

    employees = SetUtil.union(Utils.copy(employees), SetUtil.set(employee));
  }

  public void removeEmployee(final Employee employee) {

    for (Iterator iterator_27 = employees.iterator(); iterator_27.hasNext(); ) {
      Employee currentEmployee = (Employee) iterator_27.next();
      if (Employee.cg_equals(currentEmployee, employee)) {
        employees = SetUtil.diff(Utils.copy(employees), SetUtil.set(currentEmployee));
      }
    }
  }

  public Employee getEmployeeLessBusy() {

    Employee lessBusy = null;
    for (Iterator iterator_28 = employees.iterator(); iterator_28.hasNext(); ) {
      Employee employee = (Employee) iterator_28.next();
      if (Utils.equals(lessBusy, null)) {
        lessBusy = employee;
      } else {
        if (lessBusy.getNumProblems().longValue() > employee.getNumProblems().longValue()) {
          lessBusy = employee;
        }
      }
    }
    return lessBusy;
  }

  public Employee getEmployee(final String name) {

    Employee employee = null;
    for (Iterator iterator_29 = employees.iterator(); iterator_29.hasNext(); ) {
      Employee current = (Employee) iterator_29.next();
      if (Utils.equals(current.name, name)) {
        employee = current;
      }
    }
    return employee;
  }

  public String toString() {

    return "Company{"
        + "clients := "
        + Utils.toString(clients)
        + ", employees := "
        + Utils.toString(employees)
        + "}";
  }
}
