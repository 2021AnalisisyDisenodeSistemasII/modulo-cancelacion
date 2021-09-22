package starbank_cancelation;

import java.util.Arrays;

public abstract class Client {
    
    private String client_id;
    
    private String[] accounts;
    private String phone;
    private String client_name;
    private String client_occupation;
    private String client_address;
    
    public Client(String client_id, String[] accounts, String phone, String client_name, String client_occupation, String client_address) {
        this.client_id = client_id;
        this.accounts = accounts;
        this.phone = phone;
        this.client_name = client_name;
        this.client_occupation = client_occupation;
        this.client_address = client_address;
    }
    
    public Client(String[] accounts, String phone, String client_name, String client_occupation, String client_address) {
        this.accounts = accounts;
        this.phone = phone;
        this.client_name = client_name;
        this.client_occupation = client_occupation;
        this.client_address = client_address;
    }
    
    public Client(){
        //Constructor vacio
    }
    
    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }
    
    public String[] getAccounts() {
        return accounts;
    }

    public void setAccounts(String[] accounts) {
        this.accounts = accounts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_occupation() {
        return client_occupation;
    }

    public void setClient_occupation(String client_occupation) {
        this.client_occupation = client_occupation;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    @Override
    public String toString() {
        return "{" + "\n\tclient_id=" + client_id + ", \n\taccounts=" + Arrays.toString(accounts) + ", \n\tphone=" + phone + ", \n\tclient_name=" + client_name + ", \n\tclient_occupation=" + client_occupation + ", \n\tclient_address=" + client_address + "\n}";
    }
    
}
