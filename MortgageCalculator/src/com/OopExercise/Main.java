package com.OopExercise;

public class Main {


    public static void main(String[] args) {

        int principal = (int) Console.readNumber("Principal" , 1000, 1_000_000 );
        float annuallyInterest = (float) Console.readNumber("Annual Interest Rate" , 1, 30 );
        byte years = (byte) Console.readNumber("Period(Years)" , 1 ,30);

        var calulator = new Mortgage(principal, annuallyInterest, years);
        var report = new MortgageReport(calulator);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}
