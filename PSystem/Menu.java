package PSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        System.out.println("=============== Seja bem-vindo ao Sistema Folha de Pagamento ===============\n");

        Scanner input = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        EmployeeManager eManager = new EmployeeManager();
        PaySchedule scheduleManager = new PaySchedule();
        Individual indManager = new Individual();

        boolean check = true;

        while(check) {
            switch (header(input)) {
                case 1:
                    eManager.addEmployee(employees);
                    break;
                case 2:
                    eManager.removeEmployee(employees);
                    break;
                case 3:
                    indManager.setHCard(employees);
                    break;
                case 4:
                    indManager.setNewSell(employees);
                    break;
                case 5:
                    eManager.serviceTax(employees);
                case 6:
                    eManager.setEmployee(employees);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    scheduleManager.setSchedule(employees);
                case 10:
                    scheduleManager.newSchedule();
                case 11:
                    showEmployees(employees);
                    break;
                case 0:
                    check = false;
                    break;
            }
        }
    }

    private static void showEmployees(ArrayList<Employee> employees) {
        for(int i = 0; i < employees.size(); i++) {
            System.out.printf("\nID : %d\n", employees.get(i).getId());
            System.out.printf("Nome: %s\n", employees.get(i).getName());
            System.out.printf("Salário: %.2f\n\n", employees.get(i).getTotalSalary());
        }
    }
    private static int header(Scanner input) {
        System.out.println("[1] Adição de um novo funcionário.\n[2] Remoção de um funcionário.\n[3] Lançar um Cartão de Ponto.");
        System.out.println("[4] Lançar um resultado de venda.\n[5] Lançar uma taxa de serviço.\n[6] Alterar detalhes de um funcionário.");
        System.out.println("[7] Rodar a folha de pagamento para hoje.\n[8] Undo/Redo.\n[9] Agenda de Pagamento.\n[10] Criação de Novas Agendas de Pagamento.");
        System.out.println("[0] Sair.\n");
        System.out.print("Insira a operação deseja realizar: ");
        return Integer.parseInt(input.nextLine());
    }
}
