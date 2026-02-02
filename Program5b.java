//Program 5:Write a program to rearrange a given array of integers into zigzag order such that e1 < e2 > e3 < e4 > e5 < e6 ….

//Approach 2

import java.util.Scanner;

class Program5b
{
    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Zigzag logic without sorting
        for (int i = 0; i < n - 1; i++)
        {
            if (i % 2 == 0)
            {
                // Even index: arr[i] < arr[i + 1]
                if (arr[i] > arr[i + 1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            else
            {
                // Odd index: arr[i] > arr[i + 1]
                if (arr[i] < arr[i + 1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        // Print zigzag array
        System.out.println("Zigzag array:");
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}

