// Question: Write a Java program to create an interface with a method displayVolume()
// Name - ADITYA BHARDWAJ
// Section - D2
// Roll No - 07
// Course – B TECH
// Branch – CSE

import java.util.Scanner;

interface Volume
{
    void displayVolume();
}

class Cone implements Volume
{
    double r, h;

    Cone(double r, double h)
    {
        this.r = r;
        this.h = h;
    }

    @Override
    public void displayVolume()
    {
        double volume = (1.0 / 3) * 3.14 * r * r * h;
        System.out.println("Volume of Cone = " + volume);
    }
}

class Cylinder implements Volume
{
    double r, h;

    Cylinder(double r, double h)
    {
        this.r = r;
        this.h = h;
    }

    @Override
    public void displayVolume()
    {
        double volume = 3.14 * r * r * h;
        System.out.println("Volume of Cylinder = " + volume);
    }
}

class Hemisphere implements Volume
{
    double r;

    Hemisphere(double r)
    {
        this.r = r;
    }

    @Override
    public void displayVolume()
    {
        double volume = (2.0 / 3) * 3.14 * r * r * r;
        System.out.println("Volume of Hemisphere = " + volume);
    }
}

public class Program14
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of cone: ");
        double cr = sc.nextDouble();
        System.out.print("Enter height of cone: ");
        double ch = sc.nextDouble();

        System.out.print("Enter radius of cylinder: ");
        double cylr = sc.nextDouble();
        System.out.print("Enter height of cylinder: ");
        double cylh = sc.nextDouble();

        System.out.print("Enter radius of hemisphere: ");
        double hr = sc.nextDouble();

        Volume cone = new Cone(cr, ch);
        Volume cylinder = new Cylinder(cylr, cylh);
        Volume hemisphere = new Hemisphere(hr);

        cone.displayVolume();
        cylinder.displayVolume();
        hemisphere.displayVolume();

        sc.close();
    }
}

