package starbank_cancelation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ordinary_Account_JSON_Builder implements Account_Builder{
    
    private Ordinary_Account cuenta;
    private String data;
    
    public Ordinary_Account_JSON_Builder(String data) throws ParseException {
        
        this.cuenta = new Ordinary_Account();
        this.data = data;
        
        prepare_JSON_data();
        
    }
    
    private void prepare_JSON_data() throws ParseException {
        
        String aux_string = this.data;
        
        aux_string.replace("{", "");
        aux_string.replace("}", "");
        aux_string.replace("[", "");
        aux_string.replace("]", "");
        
        String[] data_splited;
        data_splited = aux_string.split(",");
        
        int reading_slot = 0;
        String[] auxArray;
        
        auxArray = data_splited[reading_slot].split("=");
        Build_isActive(Boolean.parseBoolean(auxArray[1]));
        reading_slot ++;
        
        auxArray = data_splited[reading_slot].split("=");
        Build_client_id(auxArray[1]);
        reading_slot ++;
        
        auxArray = data_splited[reading_slot].split("=");
        Build_balance(Float.parseFloat(auxArray[1]));
        reading_slot ++;
        
        auxArray = data_splited[reading_slot].split("=");
        Build_suc_id(auxArray[1]);
        reading_slot ++;
        
        String[] transactions;
        transactions = new String[0];
        Build_transactions(transactions);
        while(data_splited[reading_slot+1].contains("creation_date") == false){
            
            //IMPLEMENTACION PENDIENTE
            
            reading_slot ++;
        }
        reading_slot ++;
        
        auxArray = data_splited[reading_slot].split("=");
        Build_creation_date(new SimpleDateFormat("dd-MM-yyyy").parse(auxArray[1]));
        reading_slot ++;
        
    }
    
    @Override
    public void reset() {
        this.cuenta = new Ordinary_Account();
    }

    @Override
    public void Build_account_id(String account_id) {
        this.cuenta.setAccount_id(account_id);
    }

    @Override
    public void Build_client_id(String id) {
        this.cuenta.setClient_id(id);
    }

    @Override
    public void Build_balance(Float balance) {
        this.cuenta.setBalance(balance);
    }

    @Override
    public void Build_isActive(Boolean status) {
        this.cuenta.setIsActive(status);
    }

    @Override
    public void Build_suc_id(String sucursal_id) {
        this.cuenta.setSuc_id(sucursal_id);
    }

    @Override
    public void Build_transactions(String[] transactions) {
        this.cuenta.setTransactions(transactions);
    }

    @Override
    public void Build_creation_date(Date creation_date) {
        this.cuenta.setCreation_date(creation_date);
    }
    
    @Override
    public Ordinary_Account get_Account() {
        return this.cuenta;
    }
    
}
