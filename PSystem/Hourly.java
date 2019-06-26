package PSystem;

public class Hourly extends Employee {
    private double hourPay;
    private double rawSalary;

    public Hourly(String name, String address, int id, String paymentDay, double hourPay) {
        super(name, address, id, paymentDay);
        this.hourPay = hourPay;
        this.rawSalary = 0;
    }

    public double setDayTime(String timeIn, String timeOut) {
        String[] inAux = timeIn.split(":");
        String[] outAux = timeOut.split(":");
        int dayHours = Integer.parseInt(outAux[0])-Integer.parseInt(inAux[0]);
        double dayMinutes = (Integer.parseInt(outAux[1])-Integer.parseInt(inAux[1]))/60.0;
        if(dayMinutes < 0) dayMinutes *= -1;
        double totalHours = dayHours + dayMinutes;
        if(totalHours > 8) {
            double extra = (totalHours - 8)*0.5*hourPay;
            rawSalary = totalHours*hourPay + extra;
        }
        else rawSalary = totalHours*hourPay;
        return rawSalary;
    }

    public void setHourPay(double hourPay) { this.hourPay = hourPay; }

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
    public void setTotalSalary(double rawSalary) {
        super.totalSalary += rawSalary;
    }
}
