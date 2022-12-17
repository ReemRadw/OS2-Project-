package finalbarber;

import java.util.concurrent.*;

public class FinalBarBer extends Thread {

    public static Semaphore customers = new Semaphore(0);
    public static Semaphore barber = new Semaphore(0);
    public static Semaphore mutex = new Semaphore(1);
    public static int EmptyChair =4 ;


public static void main(String args[]) {

        FinalBarBer barberShop = new FinalBarBer();
        
        barberShop.start();
    }

    public void run() {
        // Create instance of barber
        for (int a = 1; a < 3; a++) {
            Barber b = new Barber(a);
            b.start();
        }
        //Start 
        int i = 1;
        int b = 1;
        while (true) {
            Customer c = new Customer(i,b);
            c.start();
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
            };
            i++;
            b=((b)%2)+1;
        }
    }
}

    