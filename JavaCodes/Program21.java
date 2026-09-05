/*
Aim: To create a method that removes all strings of even length from an ArrayList.

Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE
*/

import java.util.*;

public class Program21 {

    // Method to remove even length strings
    public static void removeEvenLength(ArrayList<String> list) {
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            String str = it.next();
            if (str.length() % 2 == 0) {
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("hi");
        list.add("hello");
        list.add("java");
        list.add("code");
        list.add("Adi");

        System.out.println("Before: " + list);

        removeEvenLength(list);

        System.out.println("After: " + list);
    }
}