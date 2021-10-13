package starbank_cancelation;

import java.net.URL;
import java.text.ParseException;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Controlador implements Initializable{
    
    private Servidor_Banco servidor = new Servidor_Banco();
    private Base_De_Datos banco = new Base_De_Datos();
    
    private Account_Screen_Builder Account_Render = new Account_Screen_Builder();
    
    @FXML
    private Label label_ID, label_Nombre, label_Telefono, label_Ocupacion, label_Direccion, label_Nombre_Empresa, label_Sector_Comercial;
    
    @FXML
    private TextField textFieldValidar;
    
    @FXML
    private VBox AccountsBox;
    
    @FXML
    private ImageView backgroundImg;
    
    @FXML
    public void handleButtonAction(ActionEvent event) throws ParseException{
        
        AccountsBox.getChildren().remove(0, AccountsBox.getChildren().size());
        mostrarCliente();
        
    }

    public void mostrarCliente() throws ParseException {
        
        if (banco.isNatural_Client(textFieldValidar.getText())){
            
            Natural_Client cliente_natural = new Natural_Client();
            
            cliente_natural = servidor.getCliente_Natural(textFieldValidar.getText());            
            
            label_ID.setText(cliente_natural.getClient_id());
            label_Nombre.setText(cliente_natural.getClient_name());
            label_Telefono.setText(cliente_natural.getPhone());
            label_Ocupacion.setText(cliente_natural.getClient_occupation());
            label_Direccion.setText(cliente_natural.getClient_address());
            label_Nombre_Empresa.setText("No aplica");
            label_Sector_Comercial.setText("No aplica");

            mostrarCuentas(cliente_natural.getAccounts());
            
        }
        if (banco.isCompany_Client(textFieldValidar.getText())){
            
            Company_Client cliente_empresa = new Company_Client();
            
            cliente_empresa = servidor.getCliente_Compania(textFieldValidar.getText());
            
            label_ID.setText(cliente_empresa.getClient_id());
            label_Nombre.setText(cliente_empresa.getClient_name());
            label_Telefono.setText(cliente_empresa.getPhone());
            label_Ocupacion.setText(cliente_empresa.getClient_occupation());
            label_Direccion.setText(cliente_empresa.getClient_address());
            label_Nombre_Empresa.setText(cliente_empresa.getCompany_name());
            label_Sector_Comercial.setText(cliente_empresa.getCluster());
            
            mostrarCuentas(cliente_empresa.getAccounts());
            
        }
        
    }
    
    public void mostrarCuentas(String[] cuentas) throws ParseException{
        
        for(String aux : cuentas){
            
            if (banco.isSaving_Account(aux) || banco.isOrdinary_Account(aux)){
                
                Account cuenta = servidor.getCuenta(aux);
                
                //Prueba del Account_Screen_Builder
                AccountsBox.getChildren().add(Account_Render.renderAccount(cuenta));
                
            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }
    
}
