/*
Aim: Retrieve all records from employee database using JDBC

Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE
*/

import java.sql.*;

public class retrieveEmployeeData {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeeDB", "root", "Root@1234");

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                System.out.println(
                        "Name: " + rs.getString("name") +
                        ", Code: " + rs.getInt("code") +
                        ", Designation: " + rs.getString("designation") +
                        ", Salary: " + rs.getDouble("salary")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}