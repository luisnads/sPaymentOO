package PSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {

    private Scanner input = new Scanner(System.in);
    private String[] types = {"Horista", "Assalariado", "Comissionado"};
    private String[] pMethods = {"Depósito em conta bancária", "Cheque em mãos", "Cheque pelos Correios"};
    private int id = 1;
    private int idSyndicate = 1;

    private int getEmployee(ArrayList<Employee> employees, int id) {
        for(int i = 0; i < employees.size(); i++)
            if(employees.get(i).getId() == id) return i;

        return -1;
    }
    void addEmployee(ArrayList<Employee> employees) {
        System.out.print("Insira o nome do funcionário: ");
        String name = input.nextLine();

        System.out.print("Insira o endereço do funcionário: ");
        String address = input.nextLine();

        System.out.println("Os tipos de funcionários disponíves são: ");
        for(String show : types)
            System.out.printf("⇨ %s\n", show);

        System.out.print("Insira o tipo do funcionário: ");
        String type = input.nextLine().toLowerCase();

        if(type.equals("horista")) {
            System.out.print("Insira o valor da hora do funcionário: ");
            double hourPay = Double.parseDouble(input.nextLine());
            Employee newEmployee = new Hourly(name, address, id, "semanal 1 sexta", hourPay);
            employees.add(newEmployee);
        }
        else if(type.equals("assalariado") || type.equals("comissionado")) {
            System.out.print("Insira o salário mensal do funcionário: ");
            double mensalSalary = Double.parseDouble(input.nextLine());
            if(type.equals("comissionado")) {
                System.out.print("Insira o valor da porcentagem da comissão do funcionário em decimal: ");
                double comission = Double.parseDouble(input.nextLine());
                Employee newEmployee = new Comissioned(name, address, id,
                                            "semanal 2 sexta", mensalSalary, comission);
                employees.add(newEmployee);
            }
            else {
                Employee newEmployee = new Salaried(name, address, id,
                                        "mensal $", mensalSalary );
                employees.add(newEmployee);
            }

        }
        else {
            System.out.println("Tipo não existente!");
            return;
        }
        id++;
    }
    void removeEmployee(ArrayList<Employee> employees) {
        System.out.print("Insira o ID do funcionário que será removido: ");
        int id = Integer.parseInt((input.nextLine()));
        int idFRemove = getEmployee(employees, id);
        employees.remove(idFRemove);
    }
    public void setEmployee(ArrayList<Employee> employees) {
        System.out.print("Insira o ID do funcionário que terá os detalhes alterados: ");
        int id = Integer.parseInt(input.nextLine());
        int idFChange = getEmployee(employees, id);
        if(idFChange == -1) {
            System.out.println("Funcionário não existente!");
            return;
        }
        System.out.println("Deseja mudar o nome do funcionário? [Sim] | [Não]");
        if(input.nextLine().toLowerCase().equals("sim")) {
            System.out.println("Insira o novo nome do funcionário: ");
            employees.get(idFChange).setName(input.nextLine());
        }

        System.out.println("Deseja mudar o endereço do funcionário? [Sim] | [Não]");
        if(input.nextLine().toLowerCase().equals("sim")) {
            System.out.println("Insira o novo endereço do funcionário: ");
            employees.get(idFChange).setAddress(input.nextLine());
        }

        System.out.println("Deseja mudar o tipo do funcionário? [Sim] | [Não]");
        if(input.nextLine().toLowerCase().equals("sim")) {
            System.out.println("Os tipos de funcionários disponíves são: ");
            for(String show : types)
                System.out.printf("⇨ %s\n", show);
            System.out.println("Insira o novo tipo do funcionário: ");
            String newType = input.nextLine().toLowerCase();
            if(newType.equals("horista")) {
                System.out.println("Insira o valor da hora do funcionário: ");
                double hTemp = Double.parseDouble(input.nextLine());
                Employee newTypeE = new Hourly(employees.get(idFChange).getName(), employees.get(idFChange).getAddress(),
                        employees.get(idFChange).getId(), employees.get(idFChange).getPaymentDay(), hTemp);
            }
            else if(newType.equals("assalariado")) {
                System.out.println("Insira o valor do salário mensal do funcionário: ");
                double sTemp = Double.parseDouble(input.nextLine());
                Employee newTypeE = new Salaried(employees.get(idFChange).getName(), employees.get(idFChange).getAddress(),
                        employees.get(idFChange).getId(), employees.get(idFChange).getPaymentDay(), sTemp);
            }
            else if(newType.equals("comissionado")) {
                System.out.println("Insira o valor do salário mensal do funcionário: ");
                double sTemp = Double.parseDouble(input.nextLine());
                System.out.println("Insira o valor da comissão do funcionário em formato decimal: ");
                double cTemp = Double.parseDouble(input.nextLine());
                Employee newTypeE = new Comissioned(employees.get(idFChange).getName(), employees.get(idFChange).getAddress(),
                        employees.get(idFChange).getId(), employees.get(idFChange).getPaymentDay(), sTemp, cTemp);
            }
            else
                System.out.println("Tipo não existente!");
        }

        System.out.println("Deseja mudar o método de pagamento do funcionário? [Sim} | [Não]");
        if(input.nextLine().toLowerCase().equals("sim"))
        {
            for(String show : pMethods)
                System.out.printf("⇨ %s\n", show);
            System.out.println("Insira o novo método de pagamento do funcionário: ");
            employees.get(idFChange).setPaymentMethod(input.nextLine());
        }

        System.out.println("Deseja mudar se o funcionário pertence ao sindicato? [Sim] | [Não]");
        if(input.nextLine().toLowerCase().equals("sim")) {
            System.out.println("O funcionário pertence ao sindicato? [Sim] | [Não]");
            if(input.nextLine().toLowerCase().equals("sim")) {
                employees.get(idFChange).setSyndicate(true);
                employees.get(idFChange).setSyndicateId(idSyndicate);
                System.out.println("Insira o valor da taxa sindical: ");
                employees.get(idFChange).setSyndicateTax(Double.parseDouble(input.nextLine()));
                idSyndicate++;
            }
            else {
                employees.get(idFChange).setSyndicate(false);
                employees.get(idFChange).setSyndicateId(-1);
                employees.get(idFChange).setServiceTax(0);
            }

        }

    }
    public void serviceTax(ArrayList<Employee> employees) {
        System.out.println("Insira o ID do funcionário que terá a taxa de serviço: ");
        int id = Integer.parseInt(input.nextLine());
        int idFTax = getEmployee(employees, id);
        System.out.println("Insira o valor da taxa que será cobrada: ");
        double tax = Double.parseDouble(input.nextLine());
        employees.get(idFTax).setServiceTax(tax);
    }
}
