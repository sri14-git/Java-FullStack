package org.example;
class Counter extends Thread{

    @Override
    public void run() {
        try {
            counting();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void counting() throws InterruptedException {
        for (int i=0;i<=10;i++){
            sleep(300);
            System.out.println("Counting "+i);
        }
    }
}
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Counter count= new Counter();
        count.start();
        Counter count1=new Counter();
        count1.start();



    }
}