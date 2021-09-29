package starbank_cancelation;

import java.util.Date;

public interface Account_Builder {
    
    void reset();
    
    void Set_account_id(String account_id);
    
    void Set_client_id(String client_id);
    
    void Set_balance(Float balance);
    
    void Set_isActive(Boolean status);
    
    void Set_suc_id(String sucursal_id);
    
    void Set_transactions(String[] transactions);
    
    void Set_creation_date(Date creation_date);
    
    Account get_Account();
    
}
