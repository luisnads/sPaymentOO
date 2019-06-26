package PSystem;

public abstract class Employee {

    protected String name;
    protected String address;
    protected int id;
    protected double totalSalary;
    protected String paymentMethod;
    protected String paymentDay;
    protected boolean syndicate;
    protected int syndicateId;
    protected double syndicateTax;

    public Employee(String name, String address, int id, String paymentDay) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.totalSalary = 0;
        this.paymentMethod = "Depósito em conta bancária";
        this.paymentDay = paymentDay;
        this.syndicate = false;
        this.syndicateId = -1;
        this.syndicateTax = 0;
    }

    public void setPaymentDay(String paymentDay) {
        this.paymentDay = paymentDay;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public double getTotalSalary() {
        return totalSalary;
    }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentDay() { return paymentDay; }
    public boolean getSyndicate() { return syndicate; }
    public int getSyndicateId() { return syndicateId; }
    public double getSyndicateTax() { return syndicateTax; }
    public int getId() {
        return id;
    }
    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
    public void resetTotalSalary() {}

    public abstract void setName(String name);
    public abstract void setAddress(String address);
    public abstract void setPaymentMethod(String paymentMethod);
    public abstract void setSyndicate(boolean syndicate);
    public abstract void setSyndicateId(int syndicateId);
    public abstract void setSyndicateTax(double syndicateTax);
    public abstract void setServiceTax(double serviceTax);
}
