package PSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class pSchedule {

    private ArrayList<String> paySchedule = new ArrayList<>();
    private Scanner pScanner = new Scanner(System.in);
    private AuxManager auxManager = new AuxManager();
    private ExcepctionT eMonitor = new ExcepctionT();

    public pSchedule() {
        paySchedule.add("semanal 1 sexta");
        paySchedule.add("semanal 2 sexta");
        paySchedule.add("mensal $");
    }

    public void newSchedule() {
        System.out.print("Insira a nova agenda de pagamento a ser disponibilizada: ");
        String nSchedule = pScanner.nextLine();
        paySchedule.add(nSchedule);
        System.out.println("Agenda adicionada com sucesso!");
    }

    public void setNSchedule(ArrayList<Employee> employees) {
        System.out.print("Insira o ID do funcionário que modificará a sua agenda: ");
         int sID = eMonitor.getInteger();
         int idfc = auxManager.searchEmployee(employees, sID);
         if(idfc == -1)
             System.out.println("Funcionário não existente!");
         else {
             System.out.println("As agendas disponibilizadas são: ");
             for(String p : paySchedule) System.out.printf("⇒ %s\n", p);
             System.out.print("Insira a nova agenda do funcionário: ");
             employees.get(idfc).setPaySchedule(pScanner.nextLine());
             System.out.println("Agenda modificada com sucesso!");
         }
    }
}
