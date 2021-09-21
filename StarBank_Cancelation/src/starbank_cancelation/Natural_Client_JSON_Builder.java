package starbank_cancelation;

public class Natural_Client_JSON_Builder implements Client_Builder{
    
    private Natural_Client cliente;
    private String data;
    
    public Natural_Client_JSON_Builder(String data) {
        
        this.cliente = new Natural_Client();
        this.data = data;
        
        prepare_JSON_data();
        
    }

    private void prepare_JSON_data() {
        //IMPLEMENTAR
    }
    
    @Override
    public void reset() {
        this.cliente = new Natural_Client();
    }

    @Override
    public void Build_client_id(String client_id) {
        this.cliente.setClient_id(client_id);
    }

    @Override
    public void Build_accounts(String[] accounts) {
        this.cliente.setAccounts(accounts);
    }

    @Override
    public void Build_phone(String phone) {
        this.cliente.setPhone(phone);
    }

    @Override
    public void Build_client_name(String client_name) {
        this.cliente.setClient_name(client_name);
    }

    @Override
    public void Build_client_occupation(String client_occupation) {
        this.cliente.setClient_occupation(client_occupation);
    }

    @Override
    public void Build_client_address(String client_address) {
        this.cliente.setClient_address(client_address);
    }

    @Override
    public Natural_Client get_Client() {
        return this.cliente;
    }
    
}
