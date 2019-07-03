package PSystem;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

        private ExcepctionT eMonitor = new ExcepctionT();
        private Scanner input = new Scanner(System.in);
        private ArrayList<Employee> employees = new ArrayList<>();
        private EmployeesManager eManager = new EmployeesManager();
        private pSchedule paymentManager = new pSchedule();
        private boolean check = true;

        public void loopHeader() {
            System.out.println("Insira a data inicial que o sistema está rodando (ex.: 04/07/2019): ");
            int[] initialDate = eMonitor.getSystemDate();
            System.out.println("Insira o dia da semana que o sistema está iniciando (ex.: terça-feira): ");
            String dayInfo = input.nextLine();
            Payroll payroll = new Payroll(initialDate[0], initialDate[1], dayInfo);
            while(check) {
                System.out.println();
                payroll.getDateInfo();
                switch (header(input, eMonitor)) {
                    case 0:
                        check = false;
                        break;
                    case 1:
                        eManager.addEmployee(employees);
                        break;
                    case 2:
                        eManager.rmEmployee(employees);
                        break;
                    case 3:
                        eManager.cardPoint(employees);
                        break;
                    case 4:
                        eManager.setSellResult(employees);
                        break;
                    case 5:
                        eManager.serviceTax(employees);
                        break;
                    case 6:
                        eManager.setEmployee(employees);
                        break;
                    case 7:
                        check = payroll.payAll(employees);
                        break;
                    case 9:
                        paymentManager.setNSchedule(employees);
                        break;
                    case 10:
                        paymentManager.newSchedule();
                        break;
                    case 11:
                        showEmployees(employees);

                }
            }
        }
        private int header(Scanner input, ExcepctionT eMonitor) {
            System.out.println("[1] Adição de um novo funcionário.\n[2] Remoção de um funcionário.\n[3] Lançar um Cartão de Ponto.");
            System.out.println("[4] Lançar um resultado de venda.\n[5] Lançar uma taxa de serviço.\n[6] Alterar detalhes de um funcionário.");
            System.out.println("[7] Rodar a folha de pagamento para hoje.\n[8] Undo/Redo.\n[9] Agenda de Pagamento.\n[10] Criação de Novas Agendas de Pagamento.");
            System.out.println("[0] Sair.");
            System.out.print("Insira a operação deseja realizar: ");
            return eMonitor.getInteger();
        }
        private void showEmployees(ArrayList<Employee> employees) {
            for(int i = 0; i < employees.size(); i++) {
                System.out.printf("Nome: %s\nID: %d\nForPay %.2f\n", employees.get(i).getName(), employees.get(i).getId(), employees.get(i).getForPay());
                if(employees.get(i) instanceof Hourly) {
                    System.out.println("Tipo: Horista\n");
                }
                else if(employees.get(i) instanceof Salaried) {
                    System.out.println("Tipo: Assalariado\n");
                }
                else if(employees.get(i) instanceof Comissioned) {
                    System.out.println("Tipo: Comissionado\n");
                }
            }
        }

}
