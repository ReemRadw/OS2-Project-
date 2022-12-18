/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalbarber;

import static finalbarber.FinalBarBer.EmptyChair;
import static finalbarber.FinalBarBer.barber;
import static finalbarber.FinalBarBer.customers;
import static finalbarber.FinalBarBer.mutex;
import static java.lang.Thread.sleep;

/**
 *
 * @author ME
 */
       class Barber extends Thread {

        public int BarBerID;

        public Barber(int ID) {
            BarBerID = ID;
        }

        public void run() {
            while (true) {
                try {

                    customers.acquire();
                    //System.out.println("Barber "+this.BarBerID+ " start Cutting");
                    EndcutHair();
                    barber.release();
                    //System.out.println("The barber " + this.BarBerID + " Finish cutting hair ");
                    mutex.acquire();
                    EmptyChair++;
                    mutex.release();
                    //this.cutHair();  
                } catch (InterruptedException ex) {
                }
            }
        }

        //Cut hair method
        public void EndcutHair() {
            try {
                sleep(5050);
            } catch (InterruptedException ex) {
            }
        }
    }