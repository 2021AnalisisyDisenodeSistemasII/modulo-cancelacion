package starbank_cancelation;

import java.util.Date;

public class Saving_Account extends Account{

    public Saving_Account(String account_id, String client_id, Float balance, Boolean isActive, String suc_id, String[] transactions, Date creation_date) {
        super(account_id, client_id, balance, isActive, suc_id, transactions, creation_date);
    }

    public Saving_Account(String client_id, Float balance, Boolean isActive, String suc_id, String[] transactions, Date creation_date) {
        super(client_id, balance, isActive, suc_id, transactions, creation_date);
    }

    public Saving_Account() {
        //Constructor vacio
    }
    
}
