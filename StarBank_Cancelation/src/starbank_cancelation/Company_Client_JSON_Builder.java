package starbank_cancelation;

public class Company_Client_JSON_Builder implements Client_Builder{

    private Company_Client cliente;
    private String data;
    
    public Company_Client_JSON_Builder(String data) {
        
        this.cliente = new Company_Client();
        this.data = data;
        
        prepare_JSON_data();
        
    }
    
    private void prepare_JSON_data() {
        //IMPLEMENTAR
    }
    
    @Override
    public void reset() {
        this.cliente = new Company_Client();
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

    public void Build_nit(String nit) {
        this.cliente.setNit(nit);
    }
    
    public void Build_company_name(String company_name) {
        this.cliente.setCompany_name(company_name);
    }
    
    public void Build_cluster(String cluster) {
        this.cliente.setCluster(cluster);
    }
    
    @Override
    public Company_Client get_Client() {
        return this.cliente;
    }
    
    
    
}
