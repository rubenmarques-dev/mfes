
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CompanyTests extends Tests {
  private Company company = new Company();
  private Client client = new Client("Ruben", "povoa", quotes.Type1Quote.getInstance());
  private Employee employee = new Employee("Pedro");

  private void testCompany() {

    assert_(Utils.empty(company.getClients()));
    assert_(Utils.empty(company.getEmployees()));
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

    throw new UnsupportedOperationException();
  }

  public static void main() {

    new CompanyTests().testCompany();
    new CompanyTests().addClient();
    new CompanyTests().removeClient();
    new CompanyTests().addEmployee();
    new CompanyTests().removeEmployee();
  }

  public CompanyTests() {}

  public String toString() {

    return "CompanyTests{"
        + "company := "
        + Utils.toString(company)
        + ", client := "
        + Utils.toString(client)
        + ", employee := "
        + Utils.toString(employee)
        + "}";
  }
}
