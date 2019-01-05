
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class RunAllTests {
  public static void main() {

    new ClientTests().main();
    new CompanyTests().main();
    new DocumentTests().main();
    new EmployeeTests().main();
    new PrinterTests().main();
    new ProblemTests().main();
    new TypeDocumentTests().main();
    new UserTests().main();
  }

  public RunAllTests() {}

  public String toString() {

    return "RunAllTests{}";
  }
}
