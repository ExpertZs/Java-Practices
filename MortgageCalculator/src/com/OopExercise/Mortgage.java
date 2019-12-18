package com.OopExercise;

import java.text.NumberFormat;

public class Mortgage {
    private final static byte MONTH_IN_YEAR = 12;
    private final static byte PERCENTAGE = 100;

    private int principal;
    private float annuallyInterest;
    private byte years;


    public Mortgage(int principal, float annuallyInterest, byte years) {
        this.principal = principal;
        this.annuallyInterest = annuallyInterest;
        this.years = years;
    }


    public double calculateBlance(short numberOfPaymentMade){
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayment = getNumberOfPayment();

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayment) - Math.pow(1 + monthlyInterest, numberOfPaymentMade))
                /(Math.pow(1 + monthlyInterest, numberOfPayment) - 1);

        return balance;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayment = getNumberOfPayment();

        double mortagage = principal
                * (monthlyInterest*Math.pow(1+monthlyInterest, numberOfPayment))
                / (Math.pow(1+monthlyInterest, numberOfPayment)-1);

        return mortagage;
    }

    public double [] remainingBalances(){
        var balances = new double[getNumberOfPayment()];
        for (short month = 1; balances.length >= month; month++)
            balances[month-1] = calculateBlance(month);

        return balances;
    }


    private short getNumberOfPayment() {

        return (short) (years * MONTH_IN_YEAR);
    }

    private float getMonthlyInterest() {
        return (annuallyInterest / PERCENTAGE) / MONTH_IN_YEAR;
    }

}
