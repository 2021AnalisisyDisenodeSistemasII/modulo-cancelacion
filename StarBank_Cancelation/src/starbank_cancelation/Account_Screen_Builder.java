package starbank_cancelation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class Account_Screen_Builder {

    private HBox AccountBox;
        private VBox InformationBox;
            private Label Label_account_id;
            private Label Label_balance;
            private Label Label_isActive;
            private Label Label_suc_id;
            private Label Label_creation_date;
        private Button CancelButton;
    
    public Account_Screen_Builder(){
        
    }
    
    public HBox renderAccount(Account cuenta) {
        
        //Setteando la nueva ventana
        
        AccountBox = new HBox();
            InformationBox = new VBox();
                Label_account_id = new Label();
                Label_balance = new Label();
                Label_isActive = new Label();
                Label_suc_id = new Label();
                Label_creation_date = new Label();
            CancelButton = new Button();
            
        //Aplicando la configuracion de cada item
        
        AccountBox.setAlignment(Pos.CENTER_RIGHT);
        AccountBox.setPadding(new Insets(5, 0, 5, 0));
        
        InformationBox.setSpacing(2);
        
        InformationBox.setPrefWidth(430);
        
        Label_account_id.setAlignment(Pos.CENTER_LEFT);
        
        Label_balance.setAlignment(Pos.CENTER_LEFT);
                
        Label_isActive.setAlignment(Pos.CENTER_LEFT);
        
        Label_suc_id.setAlignment(Pos.CENTER_LEFT);
        
        Label_creation_date.setAlignment(Pos.CENTER_LEFT);
        
        CancelButton.setText("Cancelar Cuenta");
        CancelButton.setTextAlignment(TextAlignment.CENTER);
        CancelButton.setPrefWidth(175);
        CancelButton.setPrefHeight(50);
        
        //Aplicando la informacion
        
        Label_account_id.setText("Cuenta ID: " + cuenta.getAccount_id());
        Label_balance.setText("Saldo: " + cuenta.getBalance().toString());
        Label_isActive.setText("Estado de la cuenta: " + cuenta.getIsActive().toString());
        Label_suc_id.setText("Sucursal origen: " + cuenta.getSuc_id());
        Label_creation_date.setText("Fecha de creacion: " + cuenta.getCreation_date().toString());
        
        //Aplicando los parentescos
        
        InformationBox.getChildren().addAll(
            Label_account_id,
            Label_balance,
            Label_isActive,
            Label_suc_id,
            Label_creation_date);
        
        AccountBox.getChildren().addAll(
            InformationBox,
            CancelButton);
        
        return AccountBox;
    }
    
}
