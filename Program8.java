/*
Question: Program to find all the patterns of 0(1+)0 in the given string.
*/

import java.util.Scanner;

public class Program8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary string: ");
        String s = sc.nextLine();

        int count = 0;
        int i = 0;

        while (i < s.length() - 2) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
                int j = i + 1;

                while (j < s.length() && s.charAt(j) == '1') {
                    j++;
                }

                if (j < s.length() && s.charAt(j) == '0') {
                    count++;
                }

                i = j;
            } else {
                i++;
            }
        }

        System.out.println("Total number of 0(1+)0 patterns: " + count);
    }
}
