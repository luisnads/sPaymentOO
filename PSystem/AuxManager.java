package PSystem;

import java.util.ArrayList;

public class AuxManager {

    public int searchEmployee(ArrayList<Employee> employees, int id) {
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    public int searchESynd(ArrayList<Employee> employees, int idSynd) {
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getSyndId() == idSynd)
                return i;
        }
        return -1;
    }

    public Hourly changeTypeH(Employee forChange, double hourPay) {
        String name = forChange.getName(), address = forChange.getAddress(), payMethod = forChange.getPayMethod();
        String paySchedule = forChange.getPaySchedule();
        boolean synd = forChange.getSynd();
        int idSynd = forChange.getSyndId(), id = forChange.getId();
        double syndTax = forChange.getSyndTax();
        Hourly temp = new Hourly(name, address, hourPay, id, paySchedule);
        temp.setSyndicate(synd);
        temp.setSyndicateId(idSynd);
        temp.setSyndTax(syndTax);
        temp.setPayMethod(payMethod);
        return temp;
    }
    public Salaried changeTypeS(Employee forChange, double mensalSalaryA) {
        String name = forChange.getName(), address = forChange.getAddress(), payMethod = forChange.getPayMethod();
        String paySchedule = forChange.getPaySchedule();
        boolean synd = forChange.getSynd();
        int idSynd = forChange.getSyndId(), id = forChange.getId();
        double syndTax = forChange.getSyndTax();
        Salaried temp = new Salaried(name, address, mensalSalaryA, id, paySchedule);
        temp.setSyndicate(synd);
        temp.setSyndicateId(idSynd);
        temp.setSyndTax(syndTax);
        temp.setPayMethod(payMethod);
        return temp;
    }
    public Comissioned changeTypeC(Employee forChange, double mensalSalaryA, double comission) {
        String name = forChange.getName(), address = forChange.getAddress(), payMethod = forChange.getPayMethod();
        String paySchedule = forChange.getPaySchedule();
        boolean synd = forChange.getSynd();
        int idSynd = forChange.getSyndId(), id = forChange.getId();
        double syndTax = forChange.getSyndTax();
        Comissioned temp = new Comissioned(name, address, mensalSalaryA, comission, id, paySchedule);
        temp.setSyndicate(synd);
        temp.setSyndicateId(idSynd);
        temp.setSyndTax(syndTax);
        temp.setPayMethod(payMethod);
        return temp;
    }

}
