package starbank_cancelation;

import java.util.ArrayList;
import java.util.Arrays;

public class Natural_Client_JSON_Builder implements Client_Builder{
    
    private Natural_Client cliente;
    private String data;
    
    public Natural_Client_JSON_Builder(String data) {
        
        this.cliente = new Natural_Client();
        this.data = data;
        
        prepare_JSON_data();
        
    }

    private void prepare_JSON_data() {
        
        String aux_string = this.data;
        
        aux_string.replace("{", "");
        aux_string.replace("}", "");
        aux_string.replace("[", "");
        aux_string.replace("]", "");
        
        String[] data_splited;
        data_splited = aux_string.split(",");
        
        int reading_slot = 0;
        String[] auxArray;
        
        //Empieza la lectura y creacion del Array cuentas
        String[] accounts;
        ArrayList<String> lista_cuentas = new ArrayList<String>();
        
        while(data_splited[reading_slot].contains("phone") == false){
            
            if (data_splited[reading_slot].contains("=")) {
                lista_cuentas.add(data_splited[reading_slot].split("=")[1]);
            } else {
            lista_cuentas.add(data_splited[reading_slot]);
            }
            
            reading_slot ++;
            
        }

        lista_cuentas.set(0, lista_cuentas.get(0).replace("[", ""));
        lista_cuentas.set(lista_cuentas.size()-1, lista_cuentas.get(lista_cuentas.size()-1).replace("]", ""));
        
        int aux = 0;
        while (aux < lista_cuentas.size()){
            lista_cuentas.set(aux, lista_cuentas.get(aux).replace(" ", ""));
            aux ++;
        }
        
        accounts = new String[lista_cuentas.size()];
        for(int i = 0; i < lista_cuentas.size();i++){
            accounts[i] = lista_cuentas.get(i);
        }
        
        Build_accounts(accounts);
        
        auxArray = data_splited[reading_slot].split("=");
        Build_phone(auxArray[1]);
        reading_slot ++;
        
        auxArray = data_splited[reading_slot].split("=");
        Build_client_name(auxArray[1]);
        reading_slot ++;
        
        auxArray = data_splited[reading_slot].split("=");
        Build_client_occupation(auxArray[1]);
        reading_slot ++;
        
        String direccion;
        
        auxArray = data_splited[reading_slot].split("=");
        direccion = auxArray[1];
        
        reading_slot ++;
        
        if(data_splited.length != reading_slot){
            direccion = direccion + data_splited[reading_slot];
            reading_slot ++;
        }
        
        Build_client_address(direccion.replace("}", ""));
        
    }
    
    @Override
    public void reset() {
        this.cliente = new Natural_Client();
    }

    @Override
    public void Build_client_id(String client_id) {
        this.cliente.setClient_id(client_id);
    }

    @Override
    public void Build_accounts(String[] accounts) {
        this.cliente.setAccounts(accounts);
    }

    @Override
    public void Build_phone(String phone) {
        this.cliente.setPhone(phone);
    }

    @Override
    public void Build_client_name(String client_name) {
        this.cliente.setClient_name(client_name);
    }

    @Override
    public void Build_client_occupation(String client_occupation) {
        this.cliente.setClient_occupation(client_occupation);
    }

    @Override
    public void Build_client_address(String client_address) {
        this.cliente.setClient_address(client_address);
    }

    @Override
    public Natural_Client get_Client() {
        return this.cliente;
    }
    
}
