// Question: Using switch statement, write a menu-driven program to calculate
// the maturity amount of a bank deposit.
//
// Name - ADITYA BHARDWAJ
// Section - D2
// Roll No - 07
// Course – B TECH
// Branch – CSE

import java.util.Scanner;

class Program2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Deposit Type:");
        System.out.println("1. Term Deposit");
        System.out.println("2. Recurring Deposit");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                // Term Deposit
                System.out.print("Enter Principal amount (p): ");
                double p = sc.nextDouble();

                System.out.print("Enter Rate of Interest (r): ");
                double r = sc.nextDouble();

                System.out.print("Enter Time period in years (n): ");
                int n = sc.nextInt();

                double amountTD = p * Math.pow((1 + r / 100), n);

                System.out.println("Maturity Amount (Term Deposit): " + amountTD);
                break;

            case 2:
                // Recurring Deposit
                System.out.print("Enter Monthly Installment (p): ");
                double monthlyP = sc.nextDouble();

                System.out.print("Enter Rate of Interest (r): ");
                double rate = sc.nextDouble();

                System.out.print("Enter Time period in months (n): ");
                int months = sc.nextInt();

                double amountRD = (monthlyP * months)
                        + (monthlyP * months * (months + 1) / 2 * rate / 100 * 1 / 12);

                System.out.println("Maturity Amount (Recurring Deposit): " + amountRD);
                break;

            default:
                System.out.println("Invalid option selected. Please choose 1 or 2.");
        }

        sc.close();
    }
}
