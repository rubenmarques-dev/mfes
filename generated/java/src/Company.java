
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Company {
  private VDMSet clients;
  private VDMSet employees;

  public void cg_init_Company_1() {

    clients = SetUtil.set();
    employees = SetUtil.set();
  }

  public Company() {

    cg_init_Company_1();
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

    for (Iterator iterator_16 = clients.iterator(); iterator_16.hasNext(); ) {
      Client currentClient = (Client) iterator_16.next();
      if (Client.cg_equals(currentClient, client)) {
        clients = SetUtil.diff(Utils.copy(clients), SetUtil.set(currentClient));
      }
    }
  }

  public void addEmployee(final Employee employee) {

    employees = SetUtil.union(Utils.copy(employees), SetUtil.set(employee));
  }

  public void removeEmployee(final Employee employee) {

    for (Iterator iterator_17 = employees.iterator(); iterator_17.hasNext(); ) {
      Employee currentEmployee = (Employee) iterator_17.next();
      if (Employee.cg_equals(currentEmployee, employee)) {
        employees = SetUtil.diff(Utils.copy(employees), SetUtil.set(currentEmployee));
      }
    }
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
