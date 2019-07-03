package PSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeesManager {

    private int id = 1, idSynd = 1;
    private String[] types = {"Horista", "Assalariado", "Comissionado"};
    private String[] pMethods = {"Depósito em conta bancária", "Cheque em mãos", "Cheque pelos correios"};
    private Scanner eScanner = new Scanner(System.in);
    private ExcepctionT eMonitor = new ExcepctionT();
    private AuxManager auxManager = new AuxManager();

    public void addEmployee(ArrayList<Employee> employees) {

        System.out.print("\nInsira o nome do novo funcionário: ");
        String nName = eScanner.nextLine();
        System.out.print("Insira o endereço do novo funcionário: ");
        String nAddress = eScanner.nextLine();

        System.out.print("Os tipos de funcionários disponíveis são:\n");
        for(String type : types) System.out.printf("⇒ %s\n", type);

        System.out.print("Insira o tipo do novo funcionário: ");
        String nType = eScanner.nextLine();
        switch (nType.toLowerCase()) {
            case "horista":
                System.out.print("Insira o valor da hora do novo funcionário: ");
                double hourPay = eMonitor.getDouble();
                Employee newEmployeeA = new Hourly(nName, nAddress, hourPay, id, "semanal 1 sexta");
                employees.add(newEmployeeA);
                id++;
                System.out.println("Funcionário adicionado com sucesso!");
                break;
            case "assalariado":
                System.out.print("Insira o valor do salário mensal do novo funcionário: ");
                double mensalSalary = eMonitor.getDouble();
                Employee newEmployeeB = new Salaried(nName, nAddress, mensalSalary, id, "mensal $");
                employees.add(newEmployeeB);
                id++;
                System.out.println("Funcionário adicionado com sucesso!");
                break;
            case "comissionado":
                System.out.print("Insira o valor do salário mensal do novo funcionário: ");
                double mensalSalaryC = eMonitor.getDouble();
                System.out.print("Insira o valor da comissão do funcionário em decimal (ex.: 0.1 = 10%): ");
                double comission = eMonitor.getDouble();
                Employee newEmployeeC = new Comissioned(nName, nAddress, mensalSalaryC, comission, id, "semanal 2 sexta");
                employees.add(newEmployeeC);
                id++;
                System.out.println("Funcionário adicionado com sucesso!");
                break;
            default:
                System.out.println("Tipo não existente, falha ao adicionar novo funcionário!");
                break;
        }
    }
    public void rmEmployee(ArrayList<Employee> employees) {
         System.out.print("Insira o ID do funcionário que será removido: ");
         int sID = eMonitor.getInteger();
         int ifrm = auxManager.searchEmployee(employees, sID);
         if(ifrm == -1)
             System.out.println("Funcionário não existente!");
         else {
             employees.remove(ifrm);
             System.out.println("Funcionário removido com sucesso!");
         }
    }
    public void serviceTax(ArrayList<Employee> employees) {
        System.out.print("Insira o ID Sindical do funcionário que terá o desconto: ");
        int sID = eMonitor.getInteger();
        int idfc = auxManager.searchESynd(employees, sID);
        if(idfc == -1)
            System.out.println("Funcionário não existente ou não pertencente ao sindicato!");
        else {
            System.out.print("Insira o valor a ser descontado: ");
            double value = eMonitor.getDouble();
            employees.get(idfc).serviceTax(value);
        }
    }
    public void cardPoint(ArrayList<Employee> employees) {
        System.out.print("Insira o ID do funcionário que terá o cartão de ponto lançado: : ");
        int sID = eMonitor.getInteger();
        int idfc = auxManager.searchEmployee(employees, sID);
        if(idfc == -1)
            System.out.println("Funcionário não existente!");
        else {
            System.out.print("Insira o horário de entrada do funcionário: ");
            int[] tIn = eMonitor.getTime();
            System.out.print("Insira o horário de saída do funcionário: ");
            int[] tOut = eMonitor.getTime();
            if(employees.get(idfc) instanceof Hourly) {
                Hourly temp = (Hourly) employees.get(idfc);
                double addForPay = temp.setCard(tIn, tOut);
                employees.get(idfc).addForPay(addForPay);
                System.out.println("Cartão de ponto lançado com sucesso!");
            }
            else System.out.println("Tipo de funcionário incorreto! Falha ao lançar cartão de ponto.");
        }
    }
    public void setSellResult(ArrayList<Employee> employees) {
        System.out.print("Insira o ID do funcionário que lançará o resultado de venda: ");
        int sID = eMonitor.getInteger();
        int idfc = auxManager.searchEmployee(employees, sID);
        if(idfc == -1)
            System.out.println("Funcionário não existente!");
        else {
            System.out.print("Insira o valor do resultado da venda: ");
            double sellResult = eMonitor.getDouble();
            if(employees.get(idfc) instanceof Comissioned) {
                Comissioned temp = (Comissioned) employees.get(idfc);
                double addForPay = temp.sellComission(sellResult);
                temp.setTotalSales(addForPay);
                employees.set(idfc, temp);
            }
            else System.out.println("Tipo de funcionário incorreto! Falha ao lançar resultado de venda.");
        }
    }
    public void setEmployee(ArrayList<Employee> employees) {
        System.out.print("Insira o ID do funcionário que terá os dados alterados: ");
        int sID = eMonitor.getInteger();
        int idfc = auxManager.searchEmployee(employees, sID);
        if(idfc == -1)
            System.out.println("Funcionário não existente!");
        else {
            String check;
            System.out.println("Deseja mudar o nome do funcionário? [Sim] | [Não]");
            check = eScanner.nextLine().toLowerCase();
            if(check.equals("sim")) {
                System.out.print("Insira o novo nome do funcionário: ");
                employees.get(idfc).setName(eScanner.nextLine());
            }
            System.out.println("Deseja mudar o endereço do funcionário? [Sim] | [Não]");
            check = eScanner.nextLine().toLowerCase();
            if(check.equals("sim")) {
                System.out.print("Insira o novo endereço do funcionário: ");
                employees.get(idfc).setAddress(eScanner.nextLine());
            }
            System.out.println("Deseja mudar o método de pagamento do funcionário? [Sim] | [Não]");
            check = eScanner.nextLine().toLowerCase();
            if(check.equals("sim")) {
                System.out.println("Os métodos de pagamento disponíveis são: ");
                for(String methods : pMethods) System.out.printf("⇒ %s\n", methods);
                System.out.print("Insira o novo método de pagamento do funcionário: ");
                employees.get(idfc).setPayMethod(eScanner.nextLine());
            }
            System.out.println("Deseja mudar se o funcionário pertence ao sindicato? [Sim] | [Não]");
            check = eScanner.nextLine().toLowerCase();
            if(check.equals("sim")) {
                System.out.println("O funcionário pertencerá ao sindicato? [Sim] | [Não]");
                check = eScanner.nextLine().toLowerCase();
                if(check.equals("sim")) {
                    employees.get(idfc).setSyndicate(true);
                    employees.get(idfc).setSyndicateId(idSynd);
                    idSynd++;
                    System.out.print("Insira o valor da nova taxa sindical do funcionário: ");
                    employees.get(idfc).setSyndTax(eMonitor.getDouble());
                }
                else if(check.equals("não")) {
                    employees.get(idfc).setSyndicate(false);
                    employees.get(idfc).setSyndicateId(-1);
                    employees.get(idfc).setSyndTax(0);
                }
            }
            System.out.println("Deseja mudar o tipo do funcionário? [Sim] | [Não]");
            check = eScanner.nextLine().toLowerCase();
            if(check.equals("sim")) {
                System.out.println("Os tipos disponíveis são: ");
                for(String type : types) System.out.printf("⇒ %s\n", type);
                System.out.print("Insira o novo tipo do funcionário: ");
                String nType = eScanner.nextLine();
                switch (nType.toLowerCase()) {
                    case "horista":
                        System.out.print("Insira o valor da hora do funcionário: ");
                        double hourPay = eMonitor.getDouble();
                        Hourly tempA = auxManager.changeTypeH(employees.get(idfc), hourPay);
                        employees.remove(idfc);
                        employees.add(tempA);
                        break;
                    case "assalariado":
                        System.out.print("Insira o valor do salário mensal do funcionário: ");
                        double mensalSalaryA = eMonitor.getDouble();
                        Salaried tempB = auxManager.changeTypeS(employees.get(idfc), mensalSalaryA);
                        employees.remove(idfc);
                        employees.add(tempB);
                        break;
                    case "comissionado":
                        System.out.print("Insira o valor do salário mensal do funcionário: ");
                        double mensalSalaryB = eMonitor.getDouble();
                        System.out.println("Insira o valor da comissão do funcionário em decimal (ex.: 0.1 = 10%): ");
                        double comission = eMonitor.getDouble();
                        Comissioned tempC = auxManager.changeTypeC(employees.get(idfc), mensalSalaryB, comission);
                        employees.remove(idfc);
                        employees.add(tempC);
                        break;
                    default:
                        System.out.println("Tipo não existente, falha ao trocar o tipo do funcionário!");
                        break;
                }
            }
        }
    }

}
