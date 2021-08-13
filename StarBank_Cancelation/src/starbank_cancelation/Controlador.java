package starbank_cancelation;

import java.net.URL;
import java.text.ParseException;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;


public class Controlador implements Initializable{
    
    private BankServer banco = new BankServer();
    
    @FXML
    private Label label_ID, label_Nombre, label_Telefono, label_Ocupacion, label_Direccion, label_Nombre_Empresa, label_Sector_Comercial;
    
    @FXML
    private TextField textFieldValidar;
    
    @FXML
    private VBox AccountsBox;
    
    @FXML
    public void handleButtonAction(ActionEvent event) throws ParseException{
        
//        Image image = new Image("/resources/StarBanklogo.jpg");
//        ImageView imageLogo = new ImageView();
//        imageLogo.setImage(image);
        
        System.out.println(textFieldValidar.getText());
        
        Natural_Client cliente = banco.getCliente_Natural(textFieldValidar.getText());
        System.out.println("Ha ingresado correctamente");
        
        label_ID.setText(cliente.getClient_id());
        label_Nombre.setText(cliente.getClient_name());
        label_Telefono.setText(cliente.getPhone());
        label_Ocupacion.setText(cliente.getClient_occupation());
        label_Direccion.setText(cliente.getClient_address());
        label_Nombre_Empresa.setText("No aplica");
        label_Sector_Comercial.setText("No aplica");
        
        AccountsBox.getChildren().remove(0, AccountsBox.getChildren().size());
        
        for(String aux : cliente.getAccounts()){
            
            if (banco.isSaving_Account(aux)){
                Label label_account_id = new Label();
                label_account_id.setText("Cuenta ID: " + banco.getCuenta_Ahorros(aux).getAccount_id());
                
                Label label_balance = new Label();
                label_balance.setText("Saldo: " + banco.getCuenta_Ahorros(aux).getBalance().toString());
                
                Label label_isActive = new Label();
                label_isActive.setText("Estado de la cuenta: " + banco.getCuenta_Ahorros(aux).getIsActive().toString());
                
                Label label_suc_id = new Label();
                label_suc_id.setText("Sucursal origen: " + banco.getCuenta_Ahorros(aux).getSuc_id());
                
                Label label_transactions = new Label();
                label_transactions.setText("Historial de transaciones: " + Arrays.toString(banco.getCuenta_Ahorros(aux).getTransactions()));
                
                Label label_creation_date = new Label();
                label_transactions.setText("Fecha de creacion: " + banco.getCuenta_Ahorros(aux).getCreation_date().toString());
                
                Label label_separacion = new Label();
                label_separacion.setText("//");
                
                AccountsBox.getChildren().addAll(label_account_id,
                        label_balance, label_isActive, label_suc_id,
                        label_transactions, label_creation_date, label_separacion);
                
            }
            
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }
    
}
