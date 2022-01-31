package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;
        System.out.println("Welcome to Obinna's Mortgage Calculator app ");
        Scanner scanner = new Scanner(System.in);

        double principal = validatePrincipal(scanner);
        double interestRate = validateInterestRate(scanner, PERCENTAGE, MONTHS_IN_YEAR);
        int durationInMonths = validateDuration(scanner, MONTHS_IN_YEAR);

        double mortgagePayment = calculateMonthlyMortgage(principal, interestRate, durationInMonths);
        printResult(mortgagePayment);

    }

    public static double calculateMonthlyMortgage(double principal, double interestRate, int durationInMonths){
        double mortgagePaymentPerMonth = principal
                * ((interestRate * Math.pow((1 + interestRate), durationInMonths))
                / (Math.pow((1 + interestRate), durationInMonths) - 1));
        return mortgagePaymentPerMonth;
    }

    private static void printResult(double mortgage){
        String result = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Your monthly mortgage payment is " + result);
    }

    private static double validatePrincipal(Scanner scanner){
        double principal = 0;
        while(true){
            System.out.print("Principal (1k - 1M): ");
            principal = scanner.nextDouble();
            if(principal >= 1000 && principal <= 1000000 )
                break;
            System.out.println("Please enter a value between 1000 and 1000000");
        }
        return principal;
    }

    private static double validateInterestRate(Scanner scanner, int percentage, int monthsInYear){
        double annualInterestRate = 0;
        while(true){
            System.out.print("Annual Interest rate in percentage: ");
            annualInterestRate = scanner.nextDouble();
            if(annualInterestRate > 0 && annualInterestRate <= 30 )
                break;
            System.out.println("Please enter a value greater than 0 and less than or equal to 30");
        }
        double interestRate = annualInterestRate / percentage / monthsInYear;
        return interestRate;
    }

    private static int validateDuration(Scanner scanner, int monthsInYear){
        int durationInMonths = 0;
        while (true){
            System.out.print("Duration in years: ");
            int duration = scanner.nextInt();
            if(duration > 0 && duration <= 15){
                durationInMonths = duration * monthsInYear;
                break;
            }
            System.out.println("Please enter a value between 1 and 15");
        }
        return durationInMonths;
    }
}
