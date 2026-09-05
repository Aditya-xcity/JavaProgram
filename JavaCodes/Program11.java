// Question: Demonstrate method overloading using arrayFunc()
// Name - ADITYA BHARDWAJ
// Section - D2
// Roll No - 07
// Course – B TECH
// Branch – CSE

import java.util.Arrays;

class ArrayDemo
{
    // Overloaded Method 1:
    // To find all pairs whose sum equals target
    void arrayFunc(int[] arr, int target)
    {
        System.out.println("Pairs of elements whose sum is " + target + " are:");
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] + arr[j] == target)
                {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + target);
                }
            }
        }
    }

    // Overloaded Method 2:
    // To merge two sorted arrays while maintaining sorted order
    void arrayFunc(int[] A, int p, int[] B, int q)
    {
        int[] merged = new int[p + q];
        int i = 0, j = 0, k = 0;

        while (i < p && j < q)
        {
            if (A[i] < B[j])
                merged[k++] = A[i++];
            else
                merged[k++] = B[j++];
        }

        while (i < p)
            merged[k++] = A[i++];

        while (j < q)
            merged[k++] = B[j++];

        for (i = 0; i < p; i++)
            A[i] = merged[i];

        for (j = 0; j < q; j++)
            B[j] = merged[p + j];

        System.out.println("Sorted Arrays:");
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));
    }
}

public class Program11
{
    public static void main(String[] args)
    {
        ArrayDemo obj = new ArrayDemo();

        int[] numbers = {4, 6, 5, -10, 8, 5, 20};
        int target = 10;
        obj.arrayFunc(numbers, target);

        int[] A = {1, 5, 6, 7, 8, 10};
        int[] B = {2, 4, 9};
        obj.arrayFunc(A, A.length, B, B.length);
    }
}

