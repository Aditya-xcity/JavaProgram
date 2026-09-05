// Program to check whether the given numbers are Friendly Pair or not
/*
Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE
*/
//import Week1
import java.util.Scanner;

public class Program3 {

    static int sumOfDivisors(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int sum1 = sumOfDivisors(num1);
        int sum2 = sumOfDivisors(num2);

        double ratio1 = (double) sum1 / num1;
        double ratio2 = (double) sum2 / num2;

        if (ratio1 == ratio2) {
            System.out.println("Friendly Pair");
        } else {
            System.out.println("Not Friendly Pair");
        }

        sc.close();
    }
}
