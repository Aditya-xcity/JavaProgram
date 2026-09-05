// Question: Demonstrate abstract class Temperature and convert Fahrenheit to Celsius
/*
Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE
*/

abstract class Temperature {
    double temp;

    abstract void setTempData(double temp);
    abstract void changeTemp();
}

class Fahrenheit extends Temperature {

    @Override
    void setTempData(double temp) {
        this.temp = temp;
    }

    @Override
    void changeTemp() {
        double c = (5.0 / 9) * (temp - 32);
        System.out.println("Temperature in Celsius: " + c);
    }
}

public class Program13 {
    public static void main(String[] args) {
        Fahrenheit f = new Fahrenheit();
        f.setTempData(98.6);
        f.changeTemp();
    }
}

