package CallCenter;

import java.util.concurrent.*;

public class CallCenter extends Thread {

    public static Semaphore customers = new Semaphore(0);
    public static Semaphore employee = new Semaphore(0);
    public static Semaphore mutex = new Semaphore(1);
    public static int AvailableCall =4 ;


public static void main(String args[]) {

        CallCenter Center = new CallCenter();
        
        Center.start();
    }

    public void run() {
        // Create instance of barber
        for (int a = 1; a < 3; a++) {
            employee b = new employee(a);
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

    