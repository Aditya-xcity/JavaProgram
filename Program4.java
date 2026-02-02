//Program 4:Write a program that takes an integer as input and replaces every digit 0 in the number with 1, then prints the updated integer.
import java.util.Scanner;

class Program4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int temp = number;
        int digits = 0;

        // Count digits
        while (temp > 0) {
            digits++;
            temp = temp / 10;
        }

        // Handle input = 0
        if (number == 0) {
            digits = 1;
        }

        // Calculate place value manually
        int placeValue = 1;
        for (int i = 1; i < digits; i++) {
            placeValue *= 10;
        }

        int newNumber = 0;

        // Process digits left to right
        while (placeValue > 0) {
            int digit = number / placeValue;

            if (digit == 0) {
                digit = 1;
            }

            newNumber = newNumber * 10 + digit;
            number = number % placeValue;
            placeValue = placeValue / 10;
        }

        System.out.println("Modified number: " + newNumber);
        sc.close();
    }
}

