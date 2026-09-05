/* Accept employee details (id, name, deptId) at runtime.

Validate:
1. Name starts with capital letter
2. Employee ID between 2001–5001
3. Dept ID between 1–5

If invalid -> throw exception
Else -> print details */

import java.util.Scanner;


class InvalidEmployeeException extends Exception {
    public InvalidEmployeeException(String message) {
        super(message);
    }
}

public class Program16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department ID: ");
            int deptId = sc.nextInt();

           
            if (!Character.isUpperCase(name.charAt(0))) {
                throw new InvalidEmployeeException("Name must start with a capital letter.");
            }

           
            if (empId < 2001 || empId > 5001) {
                throw new InvalidEmployeeException("Employee ID must be between 2001 and 5001.");
            }

      
            if (deptId < 1 || deptId > 5) {
                throw new InvalidEmployeeException("Department ID must be between 1 and 5.");
            }

       
            System.out.println("\nEmployee Details:");
            System.out.println("ID: " + empId);
            System.out.println("Name: " + name);
            System.out.println("Department ID: " + deptId);

        } catch (InvalidEmployeeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter correct data.");
        }

        sc.close();
    }
}