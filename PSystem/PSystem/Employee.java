package PSystem;

public abstract class Employee {

    private String name, address, payMethod, paySchedule;
    double forPay;
    private double syndTax;
    private int id, syndId;
    private boolean syndicate;

    public Employee(String name, String address, int id, String paySchedule) {
        this.name = name;
        this.address = address;
        this.id = id;
        this.payMethod = "Depósito em conta bancária";
        this.syndicate = false;
        this.syndId = -1;
        this.syndTax = 0;
        this.forPay = 0;
        this.paySchedule = paySchedule;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public double getForPay() { return this.forPay; }
    public String getAddress() { return this.address; }
    public String getPayMethod() { return this.payMethod; }
    public boolean getSynd() { return this.syndicate; }
    public int getSyndId() { return this.syndId; }
    public double getSyndTax() { return this.syndTax; }
    public String getPaySchedule() { return this.paySchedule; }

    public void serviceTax(double value) {
        if(syndicate) this.forPay -= value;
        else System.out.println("Funcionário não pertecente ao sindicato!");
    }
    public void addForPay(double value) { forPay += value; }

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setPayMethod(String payMethod) { this.payMethod = payMethod; }
    public void setSyndicate(boolean check) { this.syndicate = check; }
    public void setSyndicateId(int id) { this.syndId = id; }
    public void setSyndTax(double tax) { this.syndTax = tax; }
    public void setPaySchedule(String pSchedule) { this.paySchedule = pSchedule; }

    public abstract void resetForPay();

}
