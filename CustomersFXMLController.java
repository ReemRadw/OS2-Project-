/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package barberproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class CustomersFXMLController implements Initializable {
    
    @FXML
    TableView <Customer> table;
    @FXML
    TableColumn <Customer,Integer> ids;
    @FXML
    TableColumn <Customer,String> FName;   
    @FXML
    TableColumn <Customer,String> Lname;    
    @FXML
    TableColumn <Customer,String> ph1;   
    @FXML
    TableColumn <Customer,String> ph2;
    @FXML
    TableColumn <Customer,String> barber;
    
    @FXML
    TextField idc;
    @FXML
    TextField Fnamec;
    @FXML
    TextField Lnamec;
    @FXML
    TextField ph1c;
    @FXML
    TextField ph2c;
    
   
    int index;
    
    ObservableList <Customer> list;
    
    public void AddCustomer(){        
        index = table.getSelectionModel().getSelectedIndex();
                  
        if (list.size() >= 6){
        
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ALert");
            alert.setContentText("Full of Customers!");
            alert.setHeaderText("You can’t add more cutomers because the shop is full.");
            alert.showAndWait();
        }else{
            if(list.size()>=3){
               Alert w = new Alert(Alert.AlertType.WARNING);
               w.setTitle("ALert");
               w.setContentText("Waiting!!! " + "Customers will Wait untill one barber is Free. ");
               w.setHeaderText("All barbers are busy right now!!!");
               w.showAndWait();
            }
            table.getItems().add(getData());
        }
 
         idc.clear();
         Fnamec.clear();
         Lnamec.clear();
         ph1c.clear();
         ph2c.clear();
        }

   
    
    
    public void getselected(){
        index = table.getSelectionModel().getSelectedIndex();
            if (index <= -1){
                return;
            }
        
        idc.setText(ids.getCellData(index).toString());    
        Fnamec.setText(FName.getCellData(index));    
        Lnamec.setText(Lname.getCellData(index));    
        ph1c.setText(ph1.getCellData(index).toString());    
        ph2c.setText(ph2.getCellData(index).toString());    
    }
    
    public void EditCustomer(){
        
        list.set(index, getData());
        
        idc.clear();
         Fnamec.clear();
         Lnamec.clear();
         ph1c.clear();
         ph2c.clear();
    }
    
    public Customer getData(){
        Integer id = Integer.parseInt(idc.getText());
        String Fname = Fnamec.getText();
        String Lname = Lnamec.getText();
        String ph1 = ph1c.getText();
        String ph2 = ph2c.getText();
        
        return new Customer(id,Fname,Lname,ph1,ph2);
    }
    
    public void DeleteCustomer(){
         if (index <= -1){
                return;
            }
         table.getItems().remove(index);
         index = -1;
         
         idc.clear();
         Fnamec.clear();
         Lnamec.clear();
         ph1c.clear();
         ph2c.clear();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = FXCollections.observableArrayList(
//            new Customer(1,"Kareem","Nady","1245621668","15656115695"),
//           new Customer(2,"Omar","Mohamed","1245686",""),
//          new Customer(3,"Mohamed","Ali","1245686","438794837743" )
            //new Customer(4,"Ahmed","Amr","1245686","")
    );
            
        ids.setCellValueFactory(new PropertyValueFactory <Customer,Integer>("id"));
        FName.setCellValueFactory(new PropertyValueFactory <Customer,String>("FName"));
        Lname.setCellValueFactory(new PropertyValueFactory <Customer,String>("Lname"));
        ph1.setCellValueFactory(new PropertyValueFactory <Customer,String>("ph1"));
        ph2.setCellValueFactory(new PropertyValueFactory <Customer,String>("ph2"));
        
        barber.setCellValueFactory(new PropertyValueFactory <Customer,String>("barber"));
        
        table.setItems(list);
    }    
 
}

