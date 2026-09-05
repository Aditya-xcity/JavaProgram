/*To implement multithreading in Java by creating two concurrent threads that execute independently, display their names, and run with a fixed time delay.8*/


/*
Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE
*/


class Program19 extends Thread {
    private String threadName;


    Program19(String name) {
        threadName = name;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " executing, count = " + i);
                Thread.sleep(500); 
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted.");
        }
    }

    public static void main(String[] args) {
        Program19 t1 = new Program19("CSthread");
        Program19 t2 = new Program19("ITthread");

        t1.start();
        t2.start();
    }
}