package starbank_cancelation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StarBank_Cancelation extends Application{
    
    private BankServer Banco = new BankServer();
    
    @Override
    public void init(){
        
        System.out.println(Banco.getCliente("11485730"));
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        /*Codigo de FX a mano
        //Creacion del servidor de la app
        BankServer Servidor = new BankServer();
        
        //Le damos al boton el nombre de un cliente
        //Creacion del boton
        Button btn = new Button(Servidor.getClientes()[0].getNombre_titular());
        
        //Creacion de StackPane, puede cambiar a futuro
        StackPane root = new StackPane();
        
        //Añadir boton a StackPane
        root.getChildren().add(btn);
        
        //Crear Escenaria
        Scene scene = new Scene(root, 1280, 720);
        Fin de condigo FX a mano */

        
        //Codigo para añadir la ventana desde FXML SceneBuilder
        Parent root = FXMLLoader.load(getClass().getResource("InsideAccountScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        //Añadir Escena a Stage
        stage.setScene(scene);
        stage.setTitle("StarBank_Cancelaciones");
        stage.show();
        
        stage.close();
        
    }
    
    @Override
    public void stop(){
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
