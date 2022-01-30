package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        System.out.println("Welcome to Obinna's Mortgage Calculator app ");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        double principal = scanner.nextDouble();

        System.out.print("Annual Interest rate in percentage: ");
        double annualInterestRate = scanner.nextDouble();
        double interestRate = annualInterestRate / PERCENTAGE / MONTHS_IN_YEAR;

        System.out.print("Duration in months: ");
        int duration = scanner.nextInt();

        double mortgagePaymentPerMonth = principal
                * ((interestRate * Math.pow((1 + interestRate), duration))
                / (Math.pow((1 + interestRate), duration) - 1));

        String result = NumberFormat.getCurrencyInstance().format(mortgagePaymentPerMonth);
        System.out.println("Your monthly mortgage payment is " + result);
    }
}
