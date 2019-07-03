package PSystem;

public class Hourly extends Employee{

    private double hourPay;

    public Hourly(String name, String address, double hourPay, int id, String paySchedule) {
        super(name, address, id, paySchedule);
        this.hourPay = hourPay;
    }
    public double setCard(int[] tIn, int[] tOut) {
        double extra = 0;
        int tHours = tOut[0] - tIn[0];
        double minutes = (tOut[1] - tIn[1])/60.0;
        double tTime = tHours + minutes;
        if(tTime > 8)
            extra = (tTime - 8)*0.5*hourPay;
        return (tTime*hourPay) + extra;
    }

    public void resetForPay() { super.forPay = 0; }
}
