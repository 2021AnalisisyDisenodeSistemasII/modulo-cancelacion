package starbank_cancelation;

import java.util.ArrayList;

public class Company_Client_JSON_Builder implements Client_Builder{

    private Company_Client cliente;
    private String data;
    
    public Company_Client_JSON_Builder(String data) {
        
        this.cliente = new Company_Client();
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
        
        //Eliminando los [] de la primer y ultima cuenta
        lista_cuentas.set(0, lista_cuentas.get(0).replace("[", ""));
        lista_cuentas.set(lista_cuentas.size()-1, lista_cuentas.get(lista_cuentas.size()-1).replace("]", ""));
        
        //Reemplazando los espacios fantasmas en los strings
        int aux = 0;
        while (aux < lista_cuentas.size()){
            lista_cuentas.set(aux, lista_cuentas.get(aux).replace(" ", ""));
            aux ++;
        }
        
        //Llenando el Array de String con las cuentas
        accounts = new String[lista_cuentas.size()];
        for(int i = 0; i < lista_cuentas.size();i++){
            accounts[i] = lista_cuentas.get(i);
        }
        
        Set_accounts(accounts);
        
        auxArray = data_splited[reading_slot].split("=");
        Set_phone(auxArray[1]);
        reading_slot ++;
        
        auxArray = data_splited[reading_slot].split("=");
        Set_client_name(auxArray[1]);
        reading_slot ++;
        
        auxArray = data_splited[reading_slot].split("=");
        Set_client_occupation(auxArray[1]);
        reading_slot ++;
        
        String direccion;
        
        auxArray = data_splited[reading_slot].split("=");
        direccion = auxArray[1];
        
        reading_slot ++;
        
        if(data_splited[reading_slot].contains("client_id") == false){
            direccion = direccion + data_splited[reading_slot];
            reading_slot ++;
        }
        
        Set_client_address(direccion.replace("}", ""));
        
        auxArray = data_splited[reading_slot].split("=");
        Set_client_id(auxArray[1]);
        reading_slot ++;
        
        auxArray = data_splited[reading_slot].split("=");
        Set_company_name(auxArray[1]);
        reading_slot ++;

        auxArray = data_splited[reading_slot].split("=");
        Set_cluster(auxArray[1].replace("}", ""));
        reading_slot ++;
        
    }
    
    @Override
    public void reset() {
        this.cliente = new Company_Client();
    }

    @Override
    public void Set_client_id(String client_id) {
        this.cliente.setClient_id(client_id);
    }

    @Override
    public void Set_accounts(String[] accounts) {
        this.cliente.setAccounts(accounts);
    }

    @Override
    public void Set_phone(String phone) {
        this.cliente.setPhone(phone);
    }

    @Override
    public void Set_client_name(String client_name) {
        this.cliente.setClient_name(client_name);
    }

    @Override
    public void Set_client_occupation(String client_occupation) {
        this.cliente.setClient_occupation(client_occupation);
    }

    @Override
    public void Set_client_address(String client_address) {
        this.cliente.setClient_address(client_address);
    }

    public void Set_nit(String nit) {
        this.cliente.setNit(nit);
    }
    
    public void Set_company_name(String company_name) {
        this.cliente.setCompany_name(company_name);
    }
    
    public void Set_cluster(String cluster) {
        this.cliente.setCluster(cluster);
    }
    
    @Override
    public Company_Client get_Client() {
        return this.cliente;
    }
    
}
