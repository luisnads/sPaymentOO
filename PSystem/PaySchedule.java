package PSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class PaySchedule {
    private ArrayList<String> pSchedule = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    private int getEmployee(ArrayList<Employee> employees, int id) {
        for(int i = 0; i < employees.size(); i++)
            if(employees.get(i).getId() == id) return i;

        return -1;
    }

    public PaySchedule() {
        this.pSchedule.add("semanal 1 sexta");
        this.pSchedule.add("semanal 2 sexta");
        this.pSchedule.add("mensal $");
    }

    public void newSchedule() {
        System.out.println("Insira a nova agenda de pagamento criada pela empresa:");
        pSchedule.add(input.nextLine());
    }

    public void setSchedule(ArrayList<Employee> employees) {
        System.out.println("Insira o ID do funcionário que mudará a agenda de pagamento: ");
        int id = Integer.parseInt(input.nextLine());
        int idFChange = getEmployee(employees, id);
        if(idFChange == -1) {
            System.out.println("Funcionário não existente!");
            return;
        }
        System.out.println("As agendas de pagamento disponíveis são: ");
        for(String now : pSchedule) {
            System.out.printf("⇨ %s\n", now);
        }
        System.out.println("Insira a nova agenda de pagamento: ");
        employees.get(idFChange).setPaymentDay(input.nextLine());
    }

}
