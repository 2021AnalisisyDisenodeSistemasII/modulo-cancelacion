package starbank_cancelation;

public interface Client_Builder {

    void reset();
    
    void Build_client_id(String client_id);
    
    void Build_accounts(String[] accounts);
    
    void Build_phone(String phone);
    
    void Build_client_name(String client_name);
    
    void Build_client_occupation(String client_occupation);
    
    void Build_client_address(String client_address);
    
    Client get_Client();
    
}
