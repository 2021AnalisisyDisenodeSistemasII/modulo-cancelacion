package starbank_cancelation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

public class Base_De_Datos {
    
    private HashMap diccionario_clientes_naturales;
    private HashMap diccionario_clientes_empresa;
    
    private HashMap diccionario_cuentas_ahorros;
    private HashMap diccionario_cuentas_corriente;
    
    private final String direccion_clientes_naturales
            = "JSON/natural_clients.json";
    private final String direccion_clientes_empresa
            = "JSON/company_clients.json";
    
    private final String direccion_cuentas_ahorros
            = "JSON/saving_accounts.json";
    private final String direccion_cuentas_corriente
            = "JSON/current_accounts.json";
    
    public Base_De_Datos(){
        
        diccionario_clientes_naturales = new HashMap_JSON_Loader().create(direccion_clientes_naturales);
        diccionario_clientes_empresa = new HashMap_JSON_Loader().create(direccion_clientes_empresa);
        
        diccionario_cuentas_ahorros = new HashMap_JSON_Loader().create(direccion_cuentas_ahorros);
        diccionario_cuentas_corriente = new HashMap_JSON_Loader().create(direccion_cuentas_corriente);
    
    }

    public String get_Info_Cliente(String client_id){
        
        String client_data;
        
        if (isNatural_Client(client_id)){
            client_data = this.diccionario_clientes_naturales.get(client_id).toString();
            return client_data;
        }
        if (isCompany_Client(client_id)){
            client_data = this.diccionario_clientes_empresa.get(client_id).toString();
            return client_data;
        }
        
        return null;
        
    }
    
    public String get_Info_Cuenta(String account_id) throws ParseException{
        
        String account_data;
        
        if (isSaving_Account(account_id)){
            account_data = this.diccionario_cuentas_ahorros.get(account_id).toString();
            return account_data;
        }
        if (isOrdinary_Account(account_id)){
            account_data = this.diccionario_cuentas_corriente.get(account_id).toString();
            return account_data;
        }
        
        return null;
        
    }
    
    public boolean isNatural_Client(String client_id){
        return this.diccionario_clientes_naturales.containsKey(client_id);
    }
    
    public boolean isCompany_Client(String nit){
        return this.diccionario_clientes_empresa.containsKey(nit);
    }
    
    public boolean isSaving_Account(String account_id) {
        return this.diccionario_cuentas_ahorros.containsKey(account_id);
    }
    
    public boolean isOrdinary_Account(String account_id) {
        return this.diccionario_cuentas_corriente.containsKey(account_id);
    }
    
}
