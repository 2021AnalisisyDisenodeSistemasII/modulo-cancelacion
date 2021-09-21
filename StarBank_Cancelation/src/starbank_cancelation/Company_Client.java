package starbank_cancelation;

import java.util.Arrays;

public class Company_Client extends Client{
    
    private String nit;
    private String company_name;
    private String cluster;

    public Company_Client(String nit, String company_name, String cluster, String client_id, String[] accounts, String phone, String client_name, String client_occupation, String client_address) {
        super(client_id, accounts, phone, client_name, client_occupation, client_address);
        this.nit = nit;
        this.company_name = company_name;
        this.cluster = cluster;
    }
    
    public Company_Client(String company_name, String cluster, String client_id, String[] accounts, String phone, String client_name, String client_occupation, String client_address) {
        super(client_id, accounts, phone, client_name, client_occupation, client_address);
        this.company_name = company_name;
        this.cluster = cluster;
    }
    
    public Company_Client(){
        super();
        //Constructor vacio
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
    
    @Override
    public String toString() {
        return  "{" + "\n\tnit=" + nit +
                ", \n\taccounts=" + Arrays.toString(super.getAccounts()) +
                ", \n\tphone" + super.getPhone() +
                ", \n\tclient_name=" + super.getClient_name() +
                ", \n\tclient_occupation=" + super.getClient_occupation() +
                ", \n\tclient_address=" + super.getClient_address() +
                ", \n\tclient_id=" + super.getClient_id() +
                ", \n\tcompany_name="+ company_name +
                ", \n\tcluster=" + cluster + "\n}";
    }
    
}
