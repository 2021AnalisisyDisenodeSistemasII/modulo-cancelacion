package starbank_cancelation;

public class Cuenta_Ahorros {
    
    private String id_account;
    private String id_client;
    private Float balance;
    private Boolean isActive;
    private String id_suc;
    private String[] transactions;
    
    public Cuenta_Ahorros(String id_account, String id_client, Float balance, Boolean isActive, String id_suc, String[] transactions) {
        this.id_account = id_account;
        this.id_client = id_client;
        this.balance = balance;
        this.isActive = isActive;
        this.id_suc = id_suc;
        this.transactions = transactions;
    }

    public String getId_account() {
        return id_account;
    }

    public void setId_account(String id_account) {
        this.id_account = id_account;
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
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

    public String getId_suc() {
        return id_suc;
    }

    public void setId_suc(String id_suc) {
        this.id_suc = id_suc;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public void setTransactions(String[] transactions) {
        this.transactions = transactions;
    }
    
    //Este metodo puede que no funcione correctamente hay que probarlo
    @Override
    public String toString() {
        return "Cuenta_Ahorros{" + "id_account=" + id_account + ", id_client=" + id_client + ", balance=" + balance + ", isActive=" + isActive + ", id_suc=" + id_suc + ", transactions=" + transactions + '}';
    }
    
}
