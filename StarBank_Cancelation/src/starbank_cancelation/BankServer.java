package starbank_cancelation;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BankServer {
    
    //private Cliente[] clientes;
    private Cliente_Natural[] clientes_naturales;
    
    //hay que implementar esta clase
    //private Cliente_Empresa[] clientes_empresas;
    
    public BankServer(){
        
        cargarClientes();
        
    }
    
    public void cargarClientes(){
        
        String json = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader("Clientes natural.json"))){
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
        
        Cliente_Natural[] clientes_naturales = gson.fromJson(json, Cliente_Natural[].class);
        this.clientes_naturales = clientes_naturales;
        
        int i = 0;
        for (Cliente_Natural cliente_Natural : this.clientes_naturales){
            this.clientes_naturales[i].cargarCuentas();
            i++;
        }
        
        //Esto simplemente es una flag que uso para saber hasta donde esta funcionando bien
        //System.out.println("Ya lei los clientes !");
        
        //AQUI PUEDEN VER QUE LEER LA UNICA CUENTA QUE TENEMOS EN JSON YA FUNCIONA !
        
        System.out.println(this.clientes_naturales[0].getLegal_owner());
        System.out.println(this.clientes_naturales[0].getId());
        System.out.println(this.clientes_naturales[0].getCuentas_ahorros()[0].getBalance());
        
    }

    public Cliente_Natural[] getClientes_naturales() {
        return clientes_naturales;
    }

    public void setClientes(Cliente_Natural[] clientes_naturales) {
        this.clientes_naturales = clientes_naturales;
    }
    
}
