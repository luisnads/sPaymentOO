package PSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class Individual {

    private Scanner input = new Scanner(System.in);

    private int getEmployee(ArrayList<Employee> employees, int id) {
        for(int i = 0; i < employees.size(); i++)
            if(employees.get(i).getId() == id) return i;

        return -1;
    }

    public void setHCard(ArrayList<Employee> employees) {
        System.out.println("Insira o ID do funcionário que lançará o cartão de ponto: ");
        int id = Integer.parseInt(input.nextLine());
        int idFChange = getEmployee(employees, id);
        if(idFChange == -1) {
            System.out.println("Funcionário não existente!");
            return;
        }
        Hourly Temp = (Hourly) employees.get(idFChange);
        System.out.println("Insira o horário de entrada no formato (13:42): ");
        String in = input.nextLine();
        System.out.println("Insir ao horário de saída no formato (17:18): ");
        String out = input.nextLine();
        double raw = Temp.setDayTime(in, out);
        employees.get(idFChange).setTotalSalary(raw);
    }

    public void setNewSell(ArrayList<Employee> employees) {
        System.out.println("Insira o ID do funcionário que lançará o resultado de venda: ");
        int id = Integer.parseInt(input.nextLine());
        int idFChange = getEmployee(employees, id);
        if(idFChange == -1) {
            System.out.println("Funcionário não existente!");
            return;
        }
        Comissioned Temp = (Comissioned) employees.get(idFChange);
        System.out.println("Insira o valor do resultado da venda: ");
        double raw = Temp.newSell(Double.parseDouble(input.nextLine()));
        employees.get(idFChange).setTotalSalary(raw);

    }
}
