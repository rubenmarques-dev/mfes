
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CompanyTests extends Tests {
  private Company company = new Company();
  private Client client = new Client("Ruben", "povoa", company);
  private Printer printer = new Printer("FEUP", client);
  private Problem problem1 = new Problem("descricao", printer);
  private Employee employee = new Employee("Zacarias");
  private Employee employee1 = null;
  private Employee employee2 = null;

  private void testCompany() {

    assert_(Utils.empty(company.getClients()));
    assert_(Utils.equals(company.getEmployees().size(), 2L));
  }

  private void addClient() {

    company.addClient(client);
    assert_(SetUtil.inSet(client, company.getClients()));
  }

  private void removeClient() {

    company.addClient(client);
    assert_(SetUtil.inSet(client, company.getClients()));
    company.removeClient(client);
    assert_(!(SetUtil.inSet(client, company.getClients())));
  }

  private void addEmployee() {

    company.addEmployee(employee);
    assert_(SetUtil.inSet(employee, company.getEmployees()));
  }

  private void removeEmployee() {

    company.addEmployee(employee);
    assert_(SetUtil.inSet(employee, company.getEmployees()));
    company.removeEmployee(employee);
    assert_(!(SetUtil.inSet(employee, company.getEmployees())));
  }

  private void testLessBusy() {

    employee1 = company.getEmployeeLessBusy();
    assert_(Utils.equals(employee1.name, "Joao"));
    employee1.addProblem(problem1);
    employee2 = company.getEmployeeLessBusy();
    assert_(Utils.equals(employee2.name, "Carlos"));
  }

  public void testGetEmployee() {

    employee1 = company.getEmployee("Joao");
    assert_(Utils.equals(employee1.name, "Joao"));
  }

  public static void main() {

    new CompanyTests().testCompany();
    new CompanyTests().addClient();
    new CompanyTests().removeClient();
    new CompanyTests().addEmployee();
    new CompanyTests().removeEmployee();
    new CompanyTests().testLessBusy();
  }

  public CompanyTests() {}

  public String toString() {

    return "CompanyTests{"
        + "company := "
        + Utils.toString(company)
        + ", client := "
        + Utils.toString(client)
        + ", printer := "
        + Utils.toString(printer)
        + ", problem1 := "
        + Utils.toString(problem1)
        + ", employee := "
        + Utils.toString(employee)
        + ", employee1 := "
        + Utils.toString(employee1)
        + ", employee2 := "
        + Utils.toString(employee2)
        + "}";
  }
}
