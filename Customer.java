
package barberproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;



public class Customer {
    private ComboBox barber;
    int id;
    String FName,Lname,ph1,ph2;
    ObservableList List = FXCollections.observableArrayList("barber1","barber2","barber3" , "Wait");
    
    
    public Customer(int id, String FName, String Lname, String ph1, String ph2) {
        this.id = id;
        this.FName = FName;
        this.Lname = Lname;
        this.ph1 = ph1;
        this.ph2 = ph2;
        this.barber = new ComboBox(List);
    }

    public ComboBox getBarber() {
        return barber;
    }

    public void setBarber(ComboBox barber) {
        this.barber = barber;
    }

    public int getId() {
        return id;
    }

    public String getFName() {
        return FName;
    }

    public String getLname() {
        return Lname;
    }

    public String getPh1() {
        return ph1;
    }

    public String getPh2() {
        return ph2;
    }
    
    
}
