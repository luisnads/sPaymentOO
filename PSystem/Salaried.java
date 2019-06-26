package PSystem;

public class Salaried extends Employee{

    private double mensalSalary;

    public Salaried(String name, String address, int id, String paymentDay,
                    double mensalSalary) {
        super(name, address, id, paymentDay);
        this.mensalSalary = mensalSalary;
        super.totalSalary = mensalSalary;
    }

    public double getMensalSalary() {
        return mensalSalary;
    }
    public void setMensalSalary(double mensalSalary) { this.mensalSalary = mensalSalary; }

    public void setName(String name) {
        super.name = name;
    }
    public void setAddress(String address) {
        super.address = address;
    }
    public void setPaymentMethod(String paymentMethod) {
        super.paymentMethod = paymentMethod;
    }
    public void setSyndicate(boolean syndicate) {
        super.syndicate = syndicate;
    }
    public void setSyndicateId(int syndicateId) {
        super.syndicateId = syndicateId;
    }
    public void setSyndicateTax(double syndicateTax) {
        super.syndicateTax = syndicateTax;
    }
    public void setServiceTax(double serviceTax) {
        super.totalSalary -= serviceTax;
    }
    public void setTotalSalary(double raw) {
        super.totalSalary += raw;
    }
}
