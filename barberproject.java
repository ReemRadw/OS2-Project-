package barberproject;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class barberproject extends Application {
    
    @Override
    public void start(Stage Stage) throws Exception {
        try{
        Parent parent = FXMLLoader.load(getClass().getResource("Customers.fxml"));
        Scene scene = new Scene(parent);
        Stage.setTitle("BarberShop");
        Stage.setScene(scene);
        Stage.show();
        
        }catch(IOException ex){
        }
}

    public static void main(String[] args) {
        launch(args);
    }
    
}


