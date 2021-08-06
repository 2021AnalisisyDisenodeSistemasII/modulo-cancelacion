package starbank_cancelation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BankServer {
    
    private HashMap diccionario_clientes;
    
    public BankServer(){
        
        cargarClientes();
        
    }
    
    public void cargarClientes(){
        
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
        
        this.diccionario_clientes = gson.fromJson(json, HashMap.class);
        
    }
    
    public Natural_Client getCliente(String client_id){
        
        String auxiliar = this.diccionario_clientes.get(client_id).toString();
        
        Class_Generator generator = new Class_Generator();
        
        Natural_Client cliente = generator.genClient(client_id, auxiliar);
        
        return cliente;
    }
    
}
