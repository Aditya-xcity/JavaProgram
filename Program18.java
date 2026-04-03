/* Write a java program to count palindromes in a file
Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE */

import java.io.*;

public class Program18 {


    public static boolean isPalindrome(String word) {
        String clean = word.toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();
        return clean.equals(reversed);
    }

    public static void main(String[] args) {

        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("myfile.txt"));
            String line;

            while ((line = br.readLine()) != null) {

                String[] words = line.split("\\s+");

                for (String word : words) {

          
                    word = word.replaceAll("[^a-zA-Z]", "");

                    if (!word.isEmpty() && isPalindrome(word)) {
                        count++;
                    }
                }
            }

            br.close();

            System.out.println("Output will be => " + count);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}