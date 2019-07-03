package PSystem;

import java.util.Scanner;

public class ExcepctionT {

    private Scanner exScanner = new Scanner(System.in);

    public int getInteger() {
        int newInteger;
        while(true) {
            try {
                newInteger = Integer.parseInt(exScanner.nextLine());
                return newInteger;
            }
            catch(NumberFormatException e) {
                System.out.print("Não foi inserido um inteiro, tente novamente: ");
            }
        }
    }

    public double getDouble() {
        double newDouble;
        while(true) {
            try {
                newDouble = Double.parseDouble(exScanner.nextLine());
                return newDouble;
            }
            catch (NumberFormatException e) {
                System.out.print("Não foi inserido um Integer/Double, tente novamente: ");
            }
        }
    }
    public int[] getTime() {
        String[] timeIn = new String[2];
        int[] tIn = new int[2];
        boolean check = false;
        while(!check) {
            try {
                timeIn = exScanner.nextLine().split(":");
                tIn[0] = Integer.parseInt(timeIn[0]);
                tIn[1] = Integer.parseInt(timeIn[1]);
                if((tIn[0] > 23 || tIn[0] < 0) || (tIn[1] > 59 || tIn[1] < 0))
                    System.out.print("A hora inserida está incorreta, tente novamente: ");
                else check = true;
            }
            catch (NumberFormatException e) {
                System.out.print("A hora inserida está incorreta, tente novamente: ");
            }
        }
        return tIn;
    }

    public int[] getSystemDate() {
        String[] sDate = new String[3];
        int[] sysDate = new int[3];
        boolean check = false;
        while(!check) {
            try {
                sDate = exScanner.nextLine().split("/");
                sysDate[0] = Integer.parseInt(sDate[0]);
                sysDate[1] = Integer.parseInt(sDate[1]);
                sysDate[2] = Integer.parseInt(sDate[2]);
                if((sysDate[0] > 31 || sysDate[0] < 1) || (sysDate[1]+1 > 12 || sysDate[1]+1 < 1) || sysDate[2] < 0)
                    System.out.print("O a data inserida está no formato errado, tente novamente: ");
                else check = true;
            }
            catch (NumberFormatException e) {
                System.out.print("O a data inserida está no formato errado, tente novamente: ");
            }
        }
        return sysDate;
    }
}
