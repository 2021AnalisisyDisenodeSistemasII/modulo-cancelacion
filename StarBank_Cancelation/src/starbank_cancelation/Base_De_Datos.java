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
    
    public Base_De_Datos(){
        
        cargarClientes_Naturales();
        cargarClientes_Empresa();
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
    
    private void cargarClientes_Empresa(){
        
        String json = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader("JSON/company_clients.json"))){
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
        
        this.diccionario_clientes_empresa = gson.fromJson(json, HashMap.class);
        
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
        Natural_Client cliente = generator.genNaturalClient(client_id, auxiliar);
        
        return cliente;
    }
    
    public Company_Client getCliente_Empresa(String nit){
        
        String auxiliar = this.diccionario_clientes_empresa.get(nit).toString();
        Class_Generator generator = new Class_Generator();
        Company_Client cliente = generator.genCompanyClient(nit, auxiliar);
        
        return cliente;
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
