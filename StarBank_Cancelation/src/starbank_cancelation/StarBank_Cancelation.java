package starbank_cancelation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StarBank_Cancelation extends Application{
    
    private final BankServer Banco = new BankServer();
    
    @Override
    public void init(){
        
        System.out.println(Banco.getCliente("19351004"));
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //Codigo de FX a mano
        //Creacion del servidor de la app
        
        //Codigo para añadir la ventana desde FXML SceneBuilder
        Parent root = FXMLLoader.load(getClass().getResource("InsideAccountScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        //Añadir Escena a Stage
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
