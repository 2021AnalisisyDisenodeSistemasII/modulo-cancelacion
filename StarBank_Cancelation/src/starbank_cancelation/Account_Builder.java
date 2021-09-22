package starbank_cancelation;

import java.util.Date;

public interface Account_Builder {
    
    void reset();
    
    void Build_account_id(String account_id);
    
    void Build_client_id(String client_id);
    
    void Build_balance(Float balance);
    
    void Build_isActive(Boolean status);
    
    void Build_suc_id(String sucursal_id);
    
    void Build_transactions(String[] transactions);
    
    void Build_creation_date(Date creation_date);
    
    Account get_Account();
    
}
