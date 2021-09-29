package starbank_cancelation;

public interface Client_Builder {

    void reset();
    
    void Set_client_id(String client_id);
    
    void Set_accounts(String[] accounts);
    
    void Set_phone(String phone);
    
    void Set_client_name(String client_name);
    
    void Set_client_occupation(String client_occupation);
    
    void Set_client_address(String client_address);
    
    Client get_Client();
    
}
