package starbank_cancelation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

public class BankServer {
    
    private HashMap diccionario_clientes_naturales;
    //hay que implementar
    //private HashMap diccionario_clientes_empresa;
    
    private HashMap diccionario_cuentas_ahorros;
    private HashMap diccionario_cuentas_corriente;
    
    public BankServer(){
        
        cargarClientes_Naturales();
        cargarCuentas_Ahorros();
        cargarCuentas_Corriente();
        
    }
    
    private void cargarClientes_Naturales(){
        
        String json = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader("JSON/natural_clients.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        
        this.diccionario_clientes_naturales = gson.fromJson(json, HashMap.class);
        
    }
    
    private void cargarCuentas_Ahorros(){
        
        String json = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader("JSON/saving_accounts.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        
        this.diccionario_cuentas_ahorros = gson.fromJson(json, HashMap.class);
        
    }
    
    private void cargarCuentas_Corriente(){
        
        String json = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader("JSON/current_accounts.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        
        this.diccionario_cuentas_corriente = gson.fromJson(json, HashMap.class);
        
    }
    
    public Natural_Client getCliente_Natural(String client_id){
        
        String auxiliar = this.diccionario_clientes_naturales.get(client_id).toString();
        Class_Generator generator = new Class_Generator();
        Natural_Client cliente = generator.genClient(client_id, auxiliar);
        
        return cliente;
    }
    
    public Saving_Account getCuenta_Ahorros(String account_id) throws ParseException{
        
        String auxiliar = this.diccionario_cuentas_ahorros.get(account_id).toString();
        Class_Generator generator = new Class_Generator();
        Saving_Account cuenta = generator.genSavingAccount(account_id, auxiliar);
        
        return cuenta;
    }
    
    public boolean isSaving_Account(String account_id) {
        return this.diccionario_cuentas_ahorros.containsKey(account_id);
    }
    
}
