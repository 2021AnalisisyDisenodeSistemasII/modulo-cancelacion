package starbank_cancelation;

import java.util.Arrays;
import java.util.Date;

public abstract class Account {
    
    private String account_id;
    
    private String client_id;
    private Float balance;
    private Boolean isActive;
    private String suc_id;
    private String[] transactions;
    private Date creation_date;
    
    public Account(String account_id, String client_id, Float balance, Boolean isActive, String suc_id, String[] transactions, Date creation_date) {
        this.account_id = account_id;
        this.client_id = client_id;
        this.balance = balance;
        this.isActive = isActive;
        this.suc_id = suc_id;
        this.transactions = transactions;
        this.creation_date = creation_date;
    }

    public Account(String client_id, Float balance, Boolean isActive, String suc_id, String[] transactions, Date creation_date) {
        this.client_id = client_id;
        this.balance = balance;
        this.isActive = isActive;
        this.suc_id = suc_id;
        this.transactions = transactions;
        this.creation_date = creation_date;
    }
    
    public Account(){
        //Constructor vacio
    }
    
    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getSuc_id() {
        return suc_id;
    }

    public void setSuc_id(String suc_id) {
        this.suc_id = suc_id;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String[] transactions) {
        this.transactions = transactions;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
    
    @Override
    public String toString() {
        return "{" + "\n\taccount_id=" + account_id + ", \n\tclient_id=" + client_id + ", \n\tbalance=" + balance + ", \n\tisActive=" + isActive + ", \n\tsuc_id=" + suc_id + ", \n\ttransactions=" + Arrays.toString(transactions) + ", \n\tcreation_date=" + creation_date.toString() + "\n}";
    }
    
}
