import java.util.Iterator;
import java.util.Scanner;

public class Menu {

    private int testint = 1;
    
    private Company company = new Company();
    private Client feup = new Client("FEUP","São João",this.company);
    private Client inesc = new Client("INESC","São João",this.company);
    private Client selectedClient;
    private User selectedUser;
    private Employee selectEmployee;
    private Printer selectedPrinter;
    private Document selectedDocument;
    /**4
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
            System.out.println("[2] Funcion�rios");
            System.out.println("[3] Relat�rios");
            System.out.println("[4] Gerar conteudo");
            System.out.println("[5] Exit");


            System.out.print("Insira a sua escolha: ");
            // selection = testint++;
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();
            switch (selection) {
            case 1: return console.submenuClient(console);
            case 2: return console.submenuEmployee(console);
            case 3: return console.submenuEmployee(console);
            case 4: this.generateContent(); return console.mainMenu(console);
            case 5: return console;
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
            System.out.println("[6] Listar Impressoras");
            System.out.println("[7] Atrás");

            System.out.print("Insira a sua escolha: ");
            //selection = ++testint;
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
            case 1: return console.submenuCreateUser(console);
            case 2: return console.submenuDeleteUser(console);
            case 3: return console.submenuSelectUser(console);
            case 4: return console.submenuCreatePrinter(console);
            case 7: return console.submenuClient(console);
            default:
            	System.out.println("A escolha é inválida!");
            }
        } while (selection != 7);
        return console;
    }
    
    private Menu submenuCreateUser(Menu console) {
        System.out.println("Criar utilizador");
        
        System.out.println("Introduza o username: \n");
    	Scanner scanner_username = new Scanner(System.in);
    	String username = scanner_username.nextLine();
    	System.out.println("\n");
    	System.out.println("Introduza a password: \n");
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
        
        return console.submenuUserSelected(console);
    }
    
    private Menu submenuCreatePrinter(Menu console) {
        System.out.println("Criar impressora");
        
        System.out.println("Introduza a localização da impressora: \n");
    	Scanner scanner_location = new Scanner(System.in);
    	String location = scanner_location.nextLine();
    	System.out.println("\n");
    	this.selectedClient.addPrinter(new Printer(location,this.selectedClient));
        for(Iterator it = this.selectedClient.getUsers().iterator(); it.hasNext();) {
        	Printer printer = (Printer) it.next();
        	System.out.println(printer.toString());
        }
        
        return console.submenuClientSelected(console);
    }
    
    private Menu submenuUserSelected(Menu console) {
        System.out.println("UTILIZADOR");

        int selection = 0;

        do {
            System.out.println("[1] Criar Documento");
            System.out.println("[2] Apagar Documento");
            System.out.println("[3] Login Impressora Livre");
            System.out.println("[4] Atrás");

            System.out.print("Insira a sua escolha: ");
            //selection = ++testint;
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
            case 1: return console.submenuCreateDocument(console);
            case 2: return console.submenuDeleteDocument(console);
            case 3: return console.submenuLoginPrinter(console);
            case 4: return console.submenuClientSelected(console);
            default:
            	System.out.println("A escolha é inválida!");
            }
        } while (selection != 7);
        return console;
    }
    
    private Menu submenuCreateDocument(Menu console) {
        System.out.println("Criar documento");
        
        System.out.println("Introduza o numero de folhas do documento: \n");
    	Scanner scanner_sheets = new Scanner(System.in);
    	String sheets = scanner_sheets.nextLine();
    	System.out.println("\n");
    	System.out.println("Introduza o tipo do documento (1-preto e branco, 2-cor): \n");
    	Scanner scanner_type = new Scanner(System.in);
    	String type = scanner_type.nextLine();
    	System.out.println("\n");
    	System.out.println("Introduza o titulo do documento: \n");
    	Scanner scanner_title = new Scanner(System.in);
    	String title = scanner_title.nextLine();
    	System.out.println("\n");
    	if(type.equals("1"))
    		type = "PB";
    	else type = "Cor";
    	this.selectedUser.addDocument(new Document(Integer.parseInt(sheets), type, title, this.selectedUser));
        for(Iterator it = this.selectedUser.getDocuments().iterator(); it.hasNext();) {
        	Document document = (Document) it.next();
        	System.out.println(document.toString());
        }
        
        return console.submenuUserSelected(console);
    }
    
    private Menu submenuDeleteDocument(Menu console) {
        System.out.println("Apagar documentos");
       
        int selection = 0;
        if(this.selectedUser.getDocuments().size() == 0) {
        	System.out.println("Não há mais documentos para apagar");
        	return console.submenuUserSelected(console);
        }
        int i = 1;
        for(Iterator it = this.selectedUser.getDocuments().iterator(); it.hasNext();) {
        	Document document = (Document) it.next();
        	System.out.println("[" + i + "] " + document.toString());
        	i++;
        }
        Scanner input = new Scanner(System.in);
        selection = input.nextInt();
        i = 1;
        for(Iterator it = this.selectedUser.getDocuments().iterator(); it.hasNext();) {
        	Document document = (Document) it.next();
        	if(selection == i) {
        		this.selectedUser.removeDocument(document);
        		break;
        	}
        	i++;
        }
        
        return console.submenuUserSelected(console);
    }
    
    private Menu submenuLoginPrinter(Menu console) {
    	if(this.selectedUser.getDocuments().size() == 0) {
        	System.out.println("Não há documentos para imprimir, crie um primeiro");
        	return console.submenuUserSelected(console);
        }
    	
    	this.selectedPrinter = this.selectedUser.loginToPrinter();
        if(this.selectedPrinter == null){
        	System.out.println("Não há impressoras para imprimir");
        	return console.submenuUserSelected(console);
        }
    	
    	System.out.println("Selecione o Documento a Imprimir ou 0(zero) para voltar atrás: ");
    	
        this.selectedPrinter.login(this.selectedUser);

        int selection = 0;
        
        int i = 1;
        for(Iterator it = this.selectedUser.getDocuments().iterator(); it.hasNext();) {
        	Document document = (Document) it.next();
        	System.out.println("[" + i + "] " + document.toString());
        	i++;
        }
        Scanner input = new Scanner(System.in);
        selection = input.nextInt();
        i = 1;
        for(Iterator it = this.selectedUser.getDocuments().iterator(); it.hasNext();) {
        	Document document = (Document) it.next();
        	if(selection == i) {
        		this.selectedDocument = document;
        		break;
        	}
        	i++;
        }
        
        String type = this.selectedDocument.getType();
    	
        System.out.println(this.selectedUser.getBalance().intValue());
        System.out.println(this.selectedDocument.getTotalPrice().intValue());
        
        this.selectedUser.addToBalance(50);
        
        if(this.selectedUser.getBalance().intValue() <= this.selectedDocument.getTotalPrice().intValue()) {
    		System.out.println("Não tem saldo suficiente para imprimir, carregue primeiro\n");
        	return console.submenuUserSelected(console);
    	}
        
        if(type == "PB") {
        	if(this.selectedPrinter.possiblePrintBlackDocument(this.selectedDocument)) {
        		this.selectedPrinter.printDocument(this.selectedDocument);
        	}
        }
        else if(type == "Cor") {
        	if(this.selectedPrinter.possiblePrintColorDocument(this.selectedDocument)) {
        		this.selectedPrinter.printDocument(this.selectedDocument);
        	}
        }
        
        return console.submenuUserSelected(console);
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
            case 3: return console.submenuSelectEmployee(console);
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
        
        return console.submenuEmployee(console);
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
    
    private Menu submenuSelectEmployee(Menu console) {
        System.out.println("Selecione um Employee");
       
        int selection = 0;
        if(this.company.getEmployees().size() == 0) {
        	System.out.println("N�o h� employees para selecionar, crie um primeiro");
        	return console.mainMenu(console);
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
        		this.selectEmployee = employee;
        		break;
        	}
        	i++;
        }
        
        return console.submenuEmployeeSelected(console);
    }
    
    private Menu submenuEmployeeSelected(Menu console) {
        System.out.println("Employee");

        int selection = 0;

        do {
            System.out.println("[1] Resolver problema");
            System.out.println("[2] Problemas resolvidos");
            System.out.println("[3] Atr�s");

            System.out.print("Insira a sua escolha: ");
            //selection = ++testint;
            Scanner input = new Scanner(System.in);
            selection = input.nextInt();

            switch (selection) {
            case 1: return console.submenuSelectProblem(console);
            case 2: return console.submenusolvedProblems(console);
            case 3: return console.mainMenu(console);
            default:
            	System.out.println("A escolha � inv�lida!");
            }
        } while (selection != 7);
        return console;
    }
    
    
    
    private Menu submenuSelectProblem(Menu console) {
        System.out.println("Selecione um problema para resolver");
       
        int selection = 0;
        if(this.selectEmployee.getProblemsToSolve().size() == 0) {
        	System.out.println("N�o h� problemas por resolver!");
        	return console.submenuEmployeeSelected(console);
        }
        int i = 1;
        for(Iterator it = this.selectEmployee.getProblemsToSolve().iterator(); it.hasNext();) {
        	Problem problem = (Problem) it.next();
        	System.out.println("[" + i + "] " + problem.toString());
        	i++;
        }
        Scanner input = new Scanner(System.in);
        selection = input.nextInt();
        i = 1;
        for(Iterator it = this.selectEmployee.getProblemsToSolve().iterator(); it.hasNext();) {
        	Problem problem = (Problem) it.next();
        	if(selection == i) {
        		this.selectEmployee.solveProblem(problem);
        		break;
        	}
        	i++;
        }
        
        return console.submenuEmployeeSelected(console);
    }
    
    private Menu submenusolvedProblems(Menu console) {
      
        int selection = 0;
        if(this.selectEmployee.getProblemsSolved().size() == 0) {
        	System.out.println("Este funcion�rio nao resolveu nenhum problema!");
        	return console.submenuEmployeeSelected(console);
        }else {
        	  System.out.println("Problemas Resolvidos por este funcion�rio!");
              
        } 
        	
        int i = 1;
        for(Iterator it = this.selectEmployee.getProblemsSolved().iterator(); it.hasNext();) {
        	Problem problem = (Problem) it.next();
        	System.out.println("[" + i + "] " + problem.toString());
        	i++;
        }
        Scanner input = new Scanner(System.in);
        selection = input.nextInt();
        i = 1;
 
        return console.submenuEmployeeSelected(console);
    }
    
    private void generateContent() {
    	Client client1 = new Client("feup", "porto", this.company);
    	Client client2 = new Client("fep", "porto", this.company);
    	User user1 = new User("Utilizador1", "password1", client1);
    	User user2 = new User("Utilizador2", "password2", client1);
    	User user3 = new User("Utilizador3", "password3", client1);
    	User user4 = new User("Utilizador4", "password4", client2);
    	User user5 = new User("Utilizador5", "password5", client2);
    	User user6 = new User("Utilizador6", "password6", client2);
    	user1.addToBalance(300);
    	user2.addToBalance(100);
    	user3.addToBalance(50);
    	user4.addToBalance(500);
    	Printer printer1 = new Printer("escrit�rio1", client1);
    	Printer printer2 = new Printer("escrit�rio2", client1);
    	Printer printer3 = new Printer("escrit�rio3", client1);
    	Printer printer4 = new Printer("escrit�rio4", client1);
    	Printer printer5 = new Printer("escrit�rio5", client2);
    	Printer printer6 = new Printer("escrit�rio6", client2);
    	Problem problem = new Problem("descricao", printer3, this.company.getEmployeeLessBusy());
    	problem.solved = true;
    	Problem problem1 = new Problem("descricao1", printer6, this.company.getEmployeeLessBusy());
    	Problem problem2 = new Problem("descricao2", printer3, this.company.getEmployeeLessBusy());
    	Problem problem3 = new Problem("descricao3", printer2, this.company.getEmployeeLessBusy());
    	Problem problem4 = new Problem("descricao4", printer5, this.company.getEmployeeLessBusy());
    	Document document1 = new Document(5, "PB", "titulo1", user1);
    	Document document2 = new Document(10,  "Cor","titulo2", user3);
    	Document document3 = new Document(91,  "Cor","titulo3", user4);
    	Document document4 = new Document(6, "PB",  "titulo4", user1);
    	
    	
    }
    
    
}