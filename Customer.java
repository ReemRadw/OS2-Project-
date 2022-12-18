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
     class Customer extends Thread {

        public int customerID;
        public int BarberID;
        boolean needsCut = true;

        public Customer(int id,int bid) {
            customerID = id;
            BarberID =bid ;
        }

        public void run() {

            while (needsCut) {
                try {
                    //control the number of Empty chair
                    mutex.acquire();
                    if (EmptyChair > 0) {
                        //customer can enter the shop
                        System.out.println("Customer " + this.customerID + " wait Barber in Empty Chair");
                        EmptyChair--;
                        System.out.println("Now empty Chairs =(" +EmptyChair+")");
                        mutex.release();
                       
                        try {
                            customers.release();
                            StartHaircut();
                            barber.acquire();
                            System.out.println("Customer " +this.customerID+" exit");
                            needsCut = false;
                        } catch (InterruptedException ex) {
                        }
                    } else {

                        System.out.println("Empty Chair for Customer (" + this.customerID+") not founded");

                        mutex.release();

                        needsCut = false;
                    }
                } catch (InterruptedException ex) {
                }
            }
        }

        public void StartHaircut() {
            try {
                System.out.println("Customer ("+this.customerID+") start Cutting with Barber ("+this.BarberID+")");
                sleep(5050);
            } catch (InterruptedException ex) {
            }
        }

    }