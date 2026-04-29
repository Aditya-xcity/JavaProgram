/*
Aim: Create a GUI application to take employee data and store it in database using JDBC

Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE
*/

import java.sql.*;
import javax.swing.*;

public class employeeJdbcGui {

    public static void main(String[] args) {

        JFrame f = new JFrame("Employee Form");
        f.setSize(400, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("NAME");
        JLabel l2 = new JLabel("CODE");
        JLabel l3 = new JLabel("DESIGNATION");
        JLabel l4 = new JLabel("SALARY");

        JTextField t1 = new JTextField();
        JTextField t2 = new JTextField();
        JTextField t3 = new JTextField();
        JTextField t4 = new JTextField();

        JButton b1 = new JButton("SAVE");
        JButton b2 = new JButton("RESET");
        JButton b3 = new JButton("EXIT");

        l1.setBounds(30, 30, 100, 20);
        l2.setBounds(30, 60, 100, 20);
        l3.setBounds(30, 90, 100, 20);
        l4.setBounds(30, 120, 100, 20);

        t1.setBounds(150, 30, 150, 20);
        t2.setBounds(150, 60, 150, 20);
        t3.setBounds(150, 90, 150, 20);
        t4.setBounds(150, 120, 150, 20);

        b1.setBounds(30, 170, 80, 30);
        b2.setBounds(140, 170, 80, 30);
        b3.setBounds(250, 170, 80, 30);

        f.add(l1); f.add(l2); f.add(l3); f.add(l4);
        f.add(t1); f.add(t2); f.add(t3); f.add(t4);
        f.add(b1); f.add(b2); f.add(b3);

        // SAVE BUTTON
        b1.addActionListener(e -> {
            // Validate input fields
            if (t1.getText().trim().isEmpty() || t2.getText().trim().isEmpty() || 
                t3.getText().trim().isEmpty() || t4.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(f, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Connection con = null;
            PreparedStatement ps = null;
            
            try {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Establish connection - FIXED: removed duplicate line
                con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeeDB", "root", "Root@1234");
                
                // Create SQL query - specify column names to avoid issues
                String query = "INSERT INTO employee (name, code, designation, salary) VALUES (?, ?, ?, ?)";
                ps = con.prepareStatement(query);
                
                // Set parameters
                ps.setString(1, t1.getText());
                ps.setInt(2, Integer.parseInt(t2.getText()));
                ps.setString(3, t3.getText());
                ps.setDouble(4, Double.parseDouble(t4.getText()));
                
                // Execute update
                int rowsAffected = ps.executeUpdate();
                
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(f, "Record Saved Successfully!");
                    // Clear fields after successful save
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                }
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(f, "MySQL JDBC Driver not found!", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(f, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(f, "Please enter valid numeric values for Code and Salary!", "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } finally {
                // Close resources
                try {
                    if (ps != null) ps.close();
                    if (con != null) con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // RESET BUTTON
        b2.addActionListener(e -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t1.requestFocus();
        });

        // EXIT BUTTON
        b3.addActionListener(e -> System.exit(0));

        f.setVisible(true);
    }
}