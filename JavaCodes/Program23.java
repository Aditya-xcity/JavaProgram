/*
Aim: To create a method that returns a new list containing alternating elements 
from two lists of integers without modifying the original lists.

Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE
 */

import java.util.*;

public class Program23 {

    public static List<Integer> alternate(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();

        int i = 0;

        while (i < list1.size() && i < list2.size()) {
            result.add(list1.get(i));
            result.add(list2.get(i));
            i++;
        }

        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }

        while (i < list2.size()) {
            result.add(list2.get(i));
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(6, 7, 8, 9, 10, 11, 12);

        List<Integer> result = alternate(list1, list2);

        System.out.println("Result: " + result);
    }
}
