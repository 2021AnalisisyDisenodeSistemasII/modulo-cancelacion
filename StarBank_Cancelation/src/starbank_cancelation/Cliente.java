package starbank_cancelation;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Cliente {
    
    private String tipo;
    private String id_cliente;
    private String nombre_titular;
    private String ocupacion;
    private String direccion;
    private String nombre_compañia;
    private String nit;
    private String sector_comercial;
    private Cuenta[] cuentas;

    public Cliente(String tipo, String id_cliente, String nombre_titular, String ocupacion, String direccion) {
        
        //LEEME AUNQUE CREO UN CLIENTE USANDO JSON NO SE EJECUTA EL CONSTRUCTOR
        //ESTE PRINT ES LA PRUEBA DE ELLO
        System.out.println("Estoy ejecutando constructor !");
        
        this.tipo = tipo;
        this.id_cliente = id_cliente;
        this.nombre_titular = nombre_titular;
        this.ocupacion = ocupacion;
        this.direccion = direccion;
        this.nombre_compañia = null;
        this.nit = null;
        this.sector_comercial = null;
        //cargarCuentas();
        
    }
    
    public void cargarCuentas() {
        
        //Metodo incompleto por el momento
        
        String json = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader("Cuentas StarBank/"+this.nombre_titular+" - "+this.id_cliente+"/account-1.json"))){
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
        
        Cuenta[] cuentas = gson.fromJson(json, Cuenta[].class);
        this.cuentas = cuentas;
        
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_titular() {
        return nombre_titular;
    }

    public void setNombre_titular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_compañia() {
        return nombre_compañia;
    }

    public void setNombre_compañia(String nombre_compañia) {
        this.nombre_compañia = nombre_compañia;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getSector_comercial() {
        return sector_comercial;
    }

    public void setSector_comercial(String sector_comercial) {
        this.sector_comercial = sector_comercial;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }
    
    @Override
    public String toString() {
        
        //Metodo incompleto
        return null;
        
    }
    
}
