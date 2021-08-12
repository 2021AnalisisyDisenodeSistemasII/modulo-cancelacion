
package starbank_cancelation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Controlador implements Initializable{
    
    private BankServer banco = new BankServer();
    
    @FXML
    private Label labelID, labelNombre, labelOcupacion, labelDireccion, labelNombreEmpresa, labelSector;
    
    
    @FXML
    private ImageView imageLogo, imageTitulo;
    
    @FXML
    private Button botonValidar;
    
    @FXML
    private TextField textFieldValidar;
    
    @FXML
    public void handleButtonAction(ActionEvent event){
        
        Image image = new Image("/resources/StarBanklogo.jpg");
        ImageView imageLogo = new ImageView();
        imageLogo.setImage(image);
        
        System.out.println(textFieldValidar.getText());
        
        
        Natural_Client cliente = banco.getCliente(textFieldValidar.getText());
        System.out.println("Ha ingresado correctamente");
        
        labelID.setText(cliente.getClient_id());
        
        labelNombre.setText(cliente.getClient_name());
        
        labelOcupacion.setText(cliente.getClient_occupation());
        
        labelDireccion.setText(cliente.getClient_address());
          
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }
    
}
