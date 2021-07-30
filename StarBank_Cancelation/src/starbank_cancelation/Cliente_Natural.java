package starbank_cancelation;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Cliente_Natural {

    private String legal_owner;
    private String address;
    private String phone;
    private Boolean isActive;
    private String id;
    private String occupation;
    private Cuenta_Ahorros[] cuentas_ahorros;
    private Cuenta_Corriente[] cuentas_corriente;

    public Cliente_Natural(String legal_owner, String address, String phone, Boolean isActive, String id, String occupation) {
        this.legal_owner = legal_owner;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.id = id;
        this.occupation = occupation;
    }
    
    public void cargarCuentas() {
        
        //Metodo incompleto por el momento necesito implementar la carga de las cuentas corrientes
        String json = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader("Cuentas_StarBank/"+this.id+"/saving-accounts.json"))){
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
        
        Cuenta_Ahorros[] cuentas_ahorros = gson.fromJson(json, Cuenta_Ahorros[].class);
        
        this.cuentas_ahorros = cuentas_ahorros;
        
    }

    public String getLegal_owner() {
        return legal_owner;
    }

    public void setLegal_owner(String legal_owner) {
        this.legal_owner = legal_owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Cuenta_Ahorros[] getCuentas_ahorros() {
        return cuentas_ahorros;
    }

    public void setCuentas_ahorros(Cuenta_Ahorros[] cuentas_ahorros) {
        this.cuentas_ahorros = cuentas_ahorros;
    }

    public Cuenta_Corriente[] getCuentas_corriente() {
        return cuentas_corriente;
    }

    public void setCuentas_corriente(Cuenta_Corriente[] cuentas_corriente) {
        this.cuentas_corriente = cuentas_corriente;
    }
    
    
    
}
