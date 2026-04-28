/*
Aim: To develop a GUI application using Java Swing that takes a string as input 
and counts the number of vowels, displays the result, and provides Reset and Exit functionality.

Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE
*/

import javax.swing.*;
import java.awt.event.*;

public class Program24 {
    public static void main(String args[]) {
        new SwingApp();
    }
}

class SwingApp extends JFrame {
    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2;

    SwingApp() {
        l1 = new JLabel("Enter String");
        l1.setBounds(30, 30, 100, 30);
        add(l1);

        l2 = new JLabel("Result");
        l2.setBounds(30, 70, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setBounds(150, 30, 180, 30);
        add(t1);

        t2 = new JTextField();
        t2.setBounds(150, 70, 180, 30);
        add(t2);

        b1 = new JButton("CountVowel");
        b1.setBounds(20, 130, 120, 30);
        add(b1);

        b2 = new JButton("Reset");
        b2.setBounds(150, 130, 80, 30);
        add(b2);

        b3 = new JButton("Exit");
        b3.setBounds(250, 130, 80, 30);
        add(b3);

        
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = t1.getText();
                int count = countVowel(data);
                t2.setText(String.valueOf(count));
            }
        });

        
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("");
                t2.setText("");
            }
        });

        
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setLayout(null);
        setSize(400, 250);
        setTitle("Vowel Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    
    int countVowel(String str) {
        int count = 0;
        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
}