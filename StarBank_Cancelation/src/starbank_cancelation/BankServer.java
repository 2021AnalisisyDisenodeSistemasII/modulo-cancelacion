package starbank_cancelation;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BankServer {
    
    private Cliente[] clientes;
    
    public BankServer(){
        
        cargarClientes();
        
    }
    
    public void cargarClientes(){
        
        String json = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader("Clientes.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        Gson gson = new Gson();
        
        Cliente[] clientes = gson.fromJson(json, Cliente[].class);
        this.clientes = clientes;
        
        System.out.println("Ya lei las cuentas !");
        System.out.println(this.clientes[0].getNombre_titular());
        //System.out.println(this.clientes[0].getCuentas()[0].getSucursal_padre());
        
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }
    
    
    
    
}
