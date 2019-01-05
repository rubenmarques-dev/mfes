import java.util.Iterator;
import java.util.Scanner;

public class Menu {

    private int testint = 1;
    
    private Company company = new Company();
    private Client feup = new Client("FEUP","São João",this.company);
    private Client inesc = new Client("INESC","São João",this.company);
    private Client selectedClient;
    private User selectedUser;
    /**
     * @param args
     */
    public static void main(String[] args) {
    	Menu console = new Menu();
        console = console.mainMenu(console);
        System.out.println("Obrigado pela preferência, volte sempre!");
    }

    private Menu mainMenu(Menu console) {
        System.out.println("Bem vindos à gestão do serviço de impressoras");
        
        int selection = 0;

        do {
            System.out.println("[1] Clientes");
            System.out.println("[2] Funcionários");
            System.out.println("[3] Relatórios");
            System.out.println("[4] Exit");

            System.out.print("Insira a sua escolha: ");
            // selection = testint++;
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();
            switch (selection) {
            case 1: return console.submenuClient(console);
            case 2: return console.submenuEmployee(console);
            case 3: return console.submenuEmployee(console);
            case 4: return console;
            default:
                System.out.println("A escolha é inválida!");
            }
        } while (selection != 4);
        return console;
    }
    
    private Menu submenuClient(Menu console) {
        System.out.println("CLIENTES");

        int selection = 0;

        do {
            System.out.println("[1] Criar Cliente");
            System.out.println("[2] Apagar Cliente");
            System.out.println("[3] Selecionar Cliente");
            System.out.println("[4] Atrás");

            System.out.print("Insira a sua escolha: ");
            //selection = ++testint;
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
            case 1: return console.submenuCreateClient(console);
            case 2: return console.submenuDeleteClient(console);
            case 3: return console.submenuSelectClient(console);
            case 4: return console.mainMenu(console);
            default:
            	System.out.println("A escolha é inválida!");
            }
        } while (selection != 4);
        return console;
    }
    
    private Menu submenuCreateClient(Menu console) {
        System.out.println("Criar cliente");
        
        System.out.println("Introduza o nome: \n");
    	Scanner scanner_name = new Scanner(System.in);
    	String name = scanner_name.nextLine();
    	System.out.println("\n");
    	System.out.println("Introduza a localização: \n");
    	Scanner scanner_location = new Scanner(System.in);
    	String location = scanner_location.nextLine();
    	System.out.println("\n");   
    	this.company.addClient(new Client(name,location,this.company));
        for(Iterator it = this.company.getClients().iterator(); it.hasNext();) {
        	Client client = (Client) it.next();
        	System.out.println(client.toString());
        }
        
        return console.submenuClient(console);
    }
    
    private Menu submenuDeleteClient(Menu console) {
        System.out.println("Apagar cliente");
       
        int selection = 0;
        if(this.company.getClients().size() == 0) {
        	System.out.println("Não há mais clientes para apagar");
        	return console.submenuClient(console);
        }
        int i = 1;
        for(Iterator it = this.company.getClients().iterator(); it.hasNext();) {
        	Client client = (Client) it.next();
        	System.out.println("[" + i + "] " + client.toString());
        	i++;
        }
        Scanner input = new Scanner(System.in);
        selection = input.nextInt();
        i = 1;
        for(Iterator it = this.company.getClients().iterator(); it.hasNext();) {
        	Client client = (Client) it.next();
        	if(selection == i) {
        		this.company.removeClient(client);
        		break;
        	}
        	i++;
        }
        
        return console.submenuClient(console);
    }
    
    private Menu submenuSelectClient(Menu console) {
        System.out.println("Selecione um cliente");
       
        int selection = 0;
        if(this.company.getClients().size() == 0) {
        	System.out.println("Não há clientes para selecionar, crie um primeiro");
        	return console.submenuClient(console);
        }
        int i = 1;
        for(Iterator it = this.company.getClients().iterator(); it.hasNext();) {
        	Client client = (Client) it.next();
        	System.out.println("[" + i + "] " + client.toString());
        	i++;
        }
        Scanner input = new Scanner(System.in);
        selection = input.nextInt();
        i = 1;
        for(Iterator it = this.company.getClients().iterator(); it.hasNext();) {
        	Client client = (Client) it.next();
        	if(selection == i) {
        		this.selectedClient = client;
        		break;
        	}
        	i++;
        }
        
        return console.submenuClientSelected(console);
    }
    
    private Menu submenuClientSelected(Menu console) {
        System.out.println("CLIENTE");

        int selection = 0;

        do {
            System.out.println("[1] Criar Utilizador");
            System.out.println("[2] Apagar Utilizador");
            System.out.println("[3] Selecionar Utilizador");
            System.out.println("[4] Criar Impressora");
            System.out.println("[5] Apagar Impressora");
            System.out.println("[6] Selecionar Impressora");
            System.out.println("[7] Atrás");

            System.out.print("Insira a sua escolha: ");
            //selection = ++testint;
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
            case 1: return console.submenuCreateUser(console);
            case 2: return console.submenuDeleteUser(console);
            case 3: return console.submenuSelectClient(console);
            case 7: return console.submenuClient(console);
            default:
            	System.out.println("A escolha é inválida!");
            }
        } while (selection != 4);
        return console;
    }
    
    private Menu submenuCreateUser(Menu console) {
        System.out.println("Criar utilizador");
        
        System.out.println("Introduza o username: \n");
    	Scanner scanner_username = new Scanner(System.in);
    	String username = scanner_username.nextLine();
    	System.out.println("\n");
    	System.out.println("Introduza a localização: \n");
    	Scanner scanner_password = new Scanner(System.in);
    	String password = scanner_password.nextLine();
    	System.out.println("\n");   
    	this.selectedClient.addUser(new User(username,password,this.selectedClient));
        for(Iterator it = this.selectedClient.getUsers().iterator(); it.hasNext();) {
        	User user = (User) it.next();
        	System.out.println(user.toString());
        }
        
        return console.submenuClientSelected(console);
    }
    
    private Menu submenuDeleteUser(Menu console) {
        System.out.println("Apagar utilizador");
       
        int selection = 0;
        if(this.selectedClient.getUsers().size() == 0) {
        	System.out.println("Não há mais utilizadores para apagar");
        	return console.submenuClientSelected(console);
        }
        int i = 1;
        for(Iterator it = this.selectedClient.getUsers().iterator(); it.hasNext();) {
        	User user = (User) it.next();
        	System.out.println("[" + i + "] " + user.toString());
        	i++;
        }
        Scanner input = new Scanner(System.in);
        selection = input.nextInt();
        i = 1;
        for(Iterator it = this.selectedClient.getUsers().iterator(); it.hasNext();) {
        	User user = (User) it.next();
        	if(selection == i) {
        		this.selectedClient.removeUser(user);
        		break;
        	}
        	i++;
        }
        
        return console.submenuClientSelected(console);
    }
    
    private Menu submenuSelectUser(Menu console) {
        System.out.println("Selecione um utilizador");
       
        int selection = 0;
        if(this.selectedClient.getUsers().size() == 0) {
        	System.out.println("Não há utilizadores para selecionar, crie um primeiro");
        	return console.submenuClientSelected(console);
        }
        int i = 1;
        for(Iterator it = this.selectedClient.getUsers().iterator(); it.hasNext();) {
        	User user = (User) it.next();
        	System.out.println("[" + i + "] " + user.toString());
        	i++;
        }
        Scanner input = new Scanner(System.in);
        selection = input.nextInt();
        i = 1;
        for(Iterator it = this.selectedClient.getUsers().iterator(); it.hasNext();) {
        	User user = (User) it.next();
        	if(selection == i) {
        		this.selectedUser = user;
        		break;
        	}
        	i++;
        }
        
        return console.submenuClientSelected(console);
    }
    
    private Menu submenuEmployee(Menu console) {
        System.out.println("Funcionário");

        int selection = 0;

        do {
            System.out.println("[1] Criar Funcionário");
            System.out.println("[2] Apagar Funcionário");
            System.out.println("[3] Selecionar Funcionário");
            System.out.println("[4] Atrás");

            System.out.print("Insira a sua escolha: ");
            //selection = ++testint;
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
            case 1: return console.submenuCreateEmployee(console);
            case 2: return console.submenuDeleteEmployee(console);
            case 3: return console.submenuEmployee(console);
            case 4: return console.mainMenu(console);
            default:
            	System.out.println("A escolha é inválida!");
            }
        } while (selection != 4);
        return console;
    }
    
    private Menu submenuCreateEmployee(Menu console) {
        System.out.println("Criar funcionário");
        
        System.out.println("Introduza o nome: \n");
    	Scanner scanner_name = new Scanner(System.in);
    	String name = scanner_name.nextLine();
    	System.out.println("\n");
    	this.company.addEmployee(new Employee(name));
        for(Iterator it = this.company.getEmployees().iterator(); it.hasNext();) {
        	Employee employee = (Employee) it.next();
        	System.out.println(employee.toString());
        }
        
        return console.submenuClient(console);
    }
    
    private Menu submenuDeleteEmployee(Menu console) {
        System.out.println("Apagar funcionário");
       
        int selection = 0;
        if(this.company.getEmployees().size() == 0) {
        	System.out.println("Não há mais funcionários para apagar");
        	return console.submenuEmployee(console);
        }
        int i = 1;
        for(Iterator it = this.company.getEmployees().iterator(); it.hasNext();) {
        	Employee employee = (Employee) it.next();
        	System.out.println("[" + i + "] " + employee.toString());
        	i++;
        }
        Scanner input = new Scanner(System.in);
        selection = input.nextInt();
        i = 1;
        for(Iterator it = this.company.getEmployees().iterator(); it.hasNext();) {
        	Employee employee = (Employee) it.next();
        	if(selection == i) {
        		this.company.removeEmployee(employee);
        		break;
        	}
        	i++;
        }
        
        return console.submenuEmployee(console);
    }
    
}