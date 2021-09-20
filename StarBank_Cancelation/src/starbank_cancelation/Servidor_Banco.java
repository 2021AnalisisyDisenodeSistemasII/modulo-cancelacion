package starbank_cancelation;

import java.text.ParseException;

public class Servidor_Banco {
    
    private Base_De_Datos datos;
    
    public Servidor_Banco(){
        
        datos = new Base_De_Datos();
        
    }
    
    public Account getCuenta(String account_id) throws ParseException{
        
        Account cuenta;
        
        if (datos.isSaving_Account(account_id)){
            cuenta = new Saving_Account_JSON_Builder(datos.get_Info_Cuenta(account_id)).get_Account();
            cuenta.setAccount_id(account_id);
            return cuenta;
        }
        if (datos.isOrdinary_Account(account_id)){
            cuenta = new Ordinary_Account_JSON_Builder(datos.get_Info_Cuenta(account_id)).get_Account();
            cuenta.setAccount_id(account_id);
            return cuenta;
        }
        
        return null;
    }
    
}
