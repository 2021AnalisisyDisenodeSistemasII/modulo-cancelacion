package starbank_cancelation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StarBank_Cancelation extends Application{

    @Override
    public void init(){
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
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
