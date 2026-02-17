// Question: Demonstrate use of abstract class to calculate area of different shapes
/*
 Name - ADITYA BHARDWAJ
 Section - D2
 Roll No - 07
 Course – B TECH
 Branch – CSE
*/

abstract class Shape
{
    abstract int rectangleArea(int l, int b);
    abstract int squareArea(int x);
    abstract double circleArea(int r);
}

class Area extends Shape
{
    @Override
    int rectangleArea(int l, int b)
    {
        return l * b;
    }

    @Override
    int squareArea(int x)
    {
        return x * x;
    }

    @Override
    double circleArea(int r)
    {
        return 3.14 * r * r;
    }
}

public class Program12
{
    public static void main(String[] args)
    {
        Area a = new Area();

        System.out.println("Rectangle Area: " + a.rectangleArea(5, 4));
        System.out.println("Square Area: " + a.squareArea(6));
        System.out.println("Circle Area: " + a.circleArea(3));
    }
}

