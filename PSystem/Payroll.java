package PSystem;

import java.util.ArrayList;

public class Payroll {

    private int day, month, dayCount;
    private int[][] calendary = new int[13][32];

    public Payroll(int day, int month, String dayInfo) {
        this.day = day;
        this.month = month;
        this.dayCount = 0;
        int data = 0;
        switch (dayInfo) {
            case "domingo":
                data = 1;
                break;
            case "segunda-feira":
                data = 2;
                break;
            case "terça-feira":
                data = 3;
                break;
            case "quarta-feira":
                data = 4;
                break;
            case "quinta-feira":
                data = 5;
                break;
            case "sexta-feira":
                data = 6;
                break;
            case "sábado":
                data = 7;
                break;
        }
        while(month < 13) {
            while(day < 32) {
                if(((month%2) == 1 && month < 8)|| month == 8 || month == 10 || month == 12) {
                    calendary[month][day] = data;
                    data++;
                }
                else {
                    if(month == 2 && day > 28)
                        calendary[month][day] = -1;
                    else if(day == 31)
                        calendary[month][day] = -1;
                    else {
                        calendary[month][day] = data;
                        data++;
                    }
                }
                if(data == 8)
                    data = 1;
                day++;
            }
            day = 1;
            month++;
        }
    }

    public void getDateInfo() {
        System.out.printf("Data: %02d/%02d\n", day, month);
    }

    private void payEmployee(Employee employee, String[] eInfo) {
        double forPay = employee.getForPay();
        if(eInfo[0].toLowerCase().equals("semanal") && !(employee instanceof Hourly)) {
            forPay *= (Double.parseDouble(eInfo[1])/4.0);
        }
        forPay -= forPay*employee.getSyndTax();
        if(employee instanceof Comissioned) {
            Comissioned temp = (Comissioned) employee;
            double totalSales = temp.getTotalSales();
            temp.resetTotalSales();
            System.out.printf("O funcionário %s de [ID] %d recebeu %.2f via ", employee.getName(), employee.getId(), forPay+totalSales);
            employee = temp;
        }
        else
            System.out.printf("O funcionário %s de [ID] %d recebeu %.2f via ", employee.getName(), employee.getId(), forPay);
        if(employee.getPayMethod().toLowerCase().equals("cheque pelos correios"))
            System.out.printf("%s no endereço %s.\n", employee.getPayMethod(), employee.getAddress());
        else System.out.printf("%s.\n", employee.getPayMethod());
        employee.resetForPay();
    }

    private void checkWeekDay(Employee employee, String[] eInfo) {
        switch (eInfo[2].toLowerCase()) {
            case "domingo":
                if(calendary[month][day] == 1)
                    payEmployee(employee, eInfo);
                break;
            case "segunda":
                if(calendary[month][day] == 2)
                    payEmployee(employee, eInfo);
                break;
            case "terça":
                if(calendary[month][day] == 3)
                    payEmployee(employee, eInfo);
                break;
            case "quarta":
                if(calendary[month][day] == 4)
                    payEmployee(employee, eInfo);
                break;
            case "quinta":
                if(calendary[month][day] == 5)
                    payEmployee(employee, eInfo);
                break;
            case "sexta":
                if(calendary[month][day] == 6)
                    payEmployee(employee, eInfo);
                break;
            case "sábado":
                if(calendary[month][day] == 7)
                    payEmployee(employee, eInfo);
                break;
        }
    }

    public boolean payAll(ArrayList<Employee> employees) {

        int lDay = 0;
        for (int j = 31; j > 0; j--) {
            if (calendary[month][j] > 1 && calendary[month][j] < 7) {
                lDay = j;
                break;
            }
        }

        for(int i = 0; i < employees.size(); i++) {
            String[] eInfo = employees.get(i).getPaySchedule().toLowerCase().split(" ");
            if(eInfo[0].equals("semanal")) {
                if(eInfo[1].equals("1"))
                    checkWeekDay(employees.get(i), eInfo);
                else if(eInfo[1].equals("2") && (dayCount-7) >= 0)
                    checkWeekDay(employees.get(i), eInfo);
            }
            else if(eInfo[0].equals("mensal")) {
                if(eInfo[1].equals("$") && day == lDay)
                    payEmployee(employees.get(i), eInfo);
                else if(!eInfo[1].equals("$") && Integer.parseInt(eInfo[1]) == day)
                    payEmployee(employees.get(i), eInfo);
            }
        }

        day++;
        dayCount++;

        if(day > 31 || calendary[month][day] == -1) {
            day = 1;
            month++;
            if(month == 13) {
                System.out.println("Fim do ano!");
                return false;
            }
        }
        if(dayCount == 14) dayCount = 0;
        return true;
    }
}
