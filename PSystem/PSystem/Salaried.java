package PSystem;

public class Salaried extends Employee{

    double mensalSalary;

    public Salaried(String name, String address, double mensalSalary, int id, String paySchedule) {
        super(name, address, id, paySchedule);
        this.mensalSalary = mensalSalary;
        super.forPay = mensalSalary;
    }

    public void resetForPay() { super.forPay = mensalSalary; }
}
