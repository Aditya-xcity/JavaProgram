/*
Aim: To implement the Producer-Consumer problem using multithreading in Java where 
the producer produces a value only after the consumer consumes the previous value.

Name - ADITYA BHARDWAJ
Section - D2
Roll No - 07
Course – B TECH
Branch – CSE
*/

class SharedBuffer {
    private int value;
    private boolean available = false;

    public synchronized void produce(int val) {
        try {
            while (available) {
                wait();
            }
            value = val;
            System.out.println("Produced: " + value);
            available = true;
            notify();
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted");
        }
    }

    public synchronized void consume() {
        try {
            while (!available) {
                wait();
            }
            System.out.println("Consumed: " + value);
            available = false;
            notify();
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted");
        }
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;

    Producer(SharedBuffer b) {
        buffer = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    Consumer(SharedBuffer b) {
        buffer = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
        }
    }
}

public class Program20 {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);

        p.start();
        c.start();
    }
}