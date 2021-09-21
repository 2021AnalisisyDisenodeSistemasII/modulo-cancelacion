package starbank_cancelation;

import java.text.ParseException;

public class Servidor_Banco {
    
    private Base_De_Datos datos;
    
    public Servidor_Banco(){
        
        datos = new Base_De_Datos();
        
    }
    
    public Client getCliente(String id) throws ParseException {
        if (datos.isNatural_Client(id)){
            return getCliente_Natural(id);
        }
        if (datos.isCompany_Client(id)){
            return getCliente_Compania(id);
        }
        return null;
    }
    
    public Natural_Client getCliente_Natural(String client_id) {
        
        Natural_Client cliente;
        
        if (datos.isNatural_Client(client_id)){
            cliente = new Natural_Client_JSON_Builder(datos.get_Info_Cliente(client_id)).get_Client();
            cliente.setClient_id(client_id);
            return cliente;
        }
        
        return null;
        
    }
    
    public Company_Client getCliente_Compania(String nit) {
        
        Company_Client cliente;
        
        if (datos.isCompany_Client(nit)){
            cliente = new Company_Client_JSON_Builder(datos.get_Info_Cliente(nit)).get_Client();
            cliente.setNit(nit);
            return cliente;
        }
        
        return null;
        
    }
    
    public Account getCuenta(String account_id) throws ParseException{
        if (datos.isSaving_Account(account_id)){
            return getCuenta_Ahorros(account_id);
        }
        if (datos.isOrdinary_Account(account_id)){
            return getCuenta_Corriente(account_id);
        }
        return null;
    }
    
    public Saving_Account getCuenta_Ahorros(String account_id) throws ParseException {
        
        Saving_Account cuenta;
        
        if (datos.isSaving_Account(account_id)){
            cuenta = new Saving_Account_JSON_Builder(datos.get_Info_Cuenta(account_id)).get_Account();
            cuenta.setAccount_id(account_id);
            return cuenta;
        }
        
        return null;
        
    }

    public Ordinary_Account getCuenta_Corriente(String account_id) throws ParseException {
        
        Ordinary_Account cuenta;
        
        if (datos.isOrdinary_Account(account_id)){
            cuenta = new Ordinary_Account_JSON_Builder(datos.get_Info_Cuenta(account_id)).get_Account();
            cuenta.setAccount_id(account_id);
            return cuenta;
        }
        
        return null;
        
    }
    
}
