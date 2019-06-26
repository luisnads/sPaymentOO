package PSystem;

public class Comissioned extends Salaried{
    private double comission;
    private double totalSales;
    private double partialSalary;

    public Comissioned(String name, String address, int id,
                       String paymentDay, double mensalSalary, double comission) {
        super(name, address, id, paymentDay, mensalSalary);
        this.comission = comission;
        this.totalSales = 0;
    }
    public void setComission(double comission) { this.comission = comission; }

    public double newSell(double price) {
        this.totalSales += comission*price;
        return this.totalSales;
    }
    public void setPartialSalary(double partialSalary) {
        this.partialSalary = partialSalary;
    }
    public double getPartialSalary() {
        return partialSalary;
    }
}
