package com.OopExercise;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private Mortgage calculator;

    public MortgageReport(Mortgage calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }



    public void printMortgage() {
        double mortagage = calculator.calculateMortgage();
        String mortagageFormated = currency.format(mortagage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payment " + mortagageFormated);
    }


    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.remainingBalances())
               System.out.println(currency.format(balance));
        }

    }

