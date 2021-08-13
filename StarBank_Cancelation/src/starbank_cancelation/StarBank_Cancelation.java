package starbank_cancelation;

import java.text.ParseException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StarBank_Cancelation extends Application{
    
    private final BankServer Banco = new BankServer();
    
    @Override
    public void init() throws ParseException{
        
        System.out.println(Banco.getCliente_Natural("11485730"));
        //System.out.println(Banco.getCuenta_Ahorros("442ba14f27fe0ccb"));
    
        for(String aux : Banco.getCliente_Natural("11485730").getAccounts()){
            
            //cuentas
            //c6db74aabf5bec1c
            //970d95326547af75
            //652fe57e95f81fce
            if (Banco.isSaving_Account(aux)){
                System.out.println(Banco.getCuenta_Ahorros(aux));
            }
            
        }
        
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
