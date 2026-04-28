/*
Aim: To develop a GUI-based movie ticket booking system using Java Swing that 
allows users to select a movie, choose showtime, enter number of tickets, 
calculate total cost, confirm booking, reset fields, and exit the application.

Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE
*/

import javax.swing.*;
import java.awt.event.*;

public class Program25 extends JFrame {

    JComboBox<String> movieBox, timeBox;
    JTextField ticketField, resultField;
    JButton calc, confirm, reset, exit;

    Program25() {

        JLabel l1 = new JLabel("Select Movie");
        l1.setBounds(30, 30, 100, 30);
        add(l1);

        String movies[] = {"3 idiots", "Dhurandar", "Shinchan: Our Dinosaur Diary", "Sita Ram"};
        movieBox = new JComboBox<>(movies);
        movieBox.setBounds(150, 30, 180, 30);
        add(movieBox);

        JLabel l2 = new JLabel("Show Time");
        l2.setBounds(30, 70, 100, 30);
        add(l2);

        String time[] = {"10 AM", "2 PM", "3 PM", "6 PM"};
        timeBox = new JComboBox<>(time);
        timeBox.setBounds(150, 70, 180, 30);
        add(timeBox);

        JLabel l3 = new JLabel("Tickets");
        l3.setBounds(30, 110, 100, 30);
        add(l3);

        ticketField = new JTextField();
        ticketField.setBounds(150, 110, 180, 30);
        add(ticketField);

        JLabel l4 = new JLabel("Total Cost");
        l4.setBounds(30, 150, 100, 30);
        add(l4);

        resultField = new JTextField();
        resultField.setBounds(150, 150, 180, 30);
        resultField.setEditable(false);
        add(resultField);

        calc = new JButton("Calculate");
        calc.setBounds(20, 210, 100, 30);
        add(calc);

        confirm = new JButton("Confirm");
        confirm.setBounds(130, 210, 100, 30);
        add(confirm);

        reset = new JButton("Reset");
        reset.setBounds(240, 210, 80, 30);
        add(reset);

        exit = new JButton("Exit");
        exit.setBounds(150, 260, 80, 30);
        add(exit);

        
        calc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String movie = (String) movieBox.getSelectedItem();
                    int tickets = Integer.parseInt(ticketField.getText());

                    int price = 0;

                    if (movie.equals("3 idiots"))
                        price = 200;
                    else if (movie.equals("Dhurandar"))
                        price = 180;
                    else if (movie.equals("Shinchan: Our Dinosaur Diary"))
                        price = 150;
                    else
                        price = 170;

                    int total = price * tickets;
                    resultField.setText(String.valueOf(total));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Enter valid number of tickets!");
                }
            }
        });

        
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Booking Confirmed!");
            }
        });

        
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ticketField.setText("");
                resultField.setText("");
                movieBox.setSelectedIndex(0);
                timeBox.setSelectedIndex(0);
            }
        });

        
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setLayout(null);
        setSize(420, 350);
        setTitle("Movie Ticket Booking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Program25();
    }
}