
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CompanyTests extends Tests {
  private Company companyEmpty = new Company();
  private Company company = new Company();
  private Client client = new Client("Ruben", "povoa", company);
  private Printer printer = new Printer("FEUP", client);
  private Employee employee = new Employee("Zacarias");
  private Problem problem1 = null;
  private Employee employee1 = null;
  private Employee employee2 = null;

  private void testCompany() {

    assert_(Utils.empty(companyEmpty.getClients()));
    assert_(Utils.equals(company.getClients().size(), 1L));
    assert_(Utils.equals(company.getEmployees().size(), 2L));
  }

  private void addClient() {

    companyEmpty.addClient(client);
    assert_(SetUtil.inSet(client, companyEmpty.getClients()));
  }

  private void removeClient() {

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
    problem1 = new Problem("problem1", printer, employee1);
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
    new CompanyTests().testGetEmployee();
  }

  public CompanyTests() {}

  public String toString() {

    return "CompanyTests{"
        + "companyEmpty := "
        + Utils.toString(companyEmpty)
        + ", company := "
        + Utils.toString(company)
        + ", client := "
        + Utils.toString(client)
        + ", printer := "
        + Utils.toString(printer)
        + ", employee := "
        + Utils.toString(employee)
        + ", problem1 := "
        + Utils.toString(problem1)
        + ", employee1 := "
        + Utils.toString(employee1)
        + ", employee2 := "
        + Utils.toString(employee2)
        + "}";
  }
}
