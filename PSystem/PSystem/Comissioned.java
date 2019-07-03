package PSystem;

public class Comissioned extends Salaried {

    private double comission;
    private double totalSales;

    public Comissioned(String name, String address, double mensalSalary, double comission, int id, String paySchedule) {
        super(name, address, mensalSalary, id, paySchedule);
        this.comission = comission;
        this.totalSales = 0;
    }

    public double sellComission(double value) { return value*comission; }
    public void setTotalSales(double value) { this.totalSales += value; }
    public double getTotalSales() { return this.totalSales; }
    public void resetTotalSales() { this.totalSales = 0; }
}
