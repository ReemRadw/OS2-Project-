/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CallCenter;

import static CallCenter.CallCenter.customers;
import static CallCenter.CallCenter.mutex;
import static java.lang.Thread.sleep;
import static CallCenter.CallCenter.employee;
import static CallCenter.CallCenter.AvailableCall;

/**
 *
 * @author ME
 */
       class employee extends Thread {

        public int BarBerID;

        public employee(int ID) {
            BarBerID = ID;
        }

        public void run() {
            while (true) {
                try {

                    customers.acquire();
                    EndcutHair();
                    employee.release();
                    mutex.acquire();
                    AvailableCall++;
                    mutex.release();
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