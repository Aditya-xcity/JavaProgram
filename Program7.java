//Program 7: Write a program to find and print the coordinates of the saddle point in a given matrix, where a saddle point is an element that is the minimum in its row and maximum in its column.
// Name - ADITYA BHARDWAJ
// Section - D2
// Roll No - 07
// Course – B TECH
// Branch – CSE

import java.util.Scanner;

class Program7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] mat = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        boolean found = false;

        for (int i = 0; i < rows; i++) {

            int minRow = mat[i][0];
            int colIndex = 0;

            // Find minimum in the current row
            for (int j = 1; j < cols; j++) {
                if (mat[i][j] < minRow) {
                    minRow = mat[i][j];
                    colIndex = j;
                }
            }

            // Check if this minimum is maximum in its column
            int k;
            for (k = 0; k < rows; k++) {
                if (mat[k][colIndex] > minRow) {
                    break;
                }
            }

            if (k == rows) {
                System.out.println("Saddle point found at coordinates: (" + i + ", " + colIndex + ")");
                System.out.println("Saddle point value: " + minRow);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No saddle point found in the matrix.");
        }

        sc.close();
    }
}

