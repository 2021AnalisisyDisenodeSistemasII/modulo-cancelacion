package starbank_cancelation;

import java.text.ParseException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StarBank_Cancelation extends Application{

    @Override
    public void init() throws ParseException{

    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("InsideAccountScreen.fxml"));
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("StarBank_Cancelaciones");
        stage.show();
        
    }
    
    @Override
    public void stop(){
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
