/*
Aim: To write a method that swaps elements of an ArrayList of Strings in a pairwise manner.

Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE
*/

import java.util.*;

public class Program22 {

    // Method to swap pairs
    public static void swapPairs(ArrayList<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("four");
        list.add("score");
        list.add("and");
        list.add("seven");
        list.add("years");
        list.add("ago");

        System.out.println("Before: " + list);

        swapPairs(list);

        System.out.println("After: " + list);
    }
}