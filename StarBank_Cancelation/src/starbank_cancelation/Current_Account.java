package starbank_cancelation;

import java.util.Date;

public class Current_Account extends Account{

    public Current_Account(String account_id, String client_id, Float balance, Boolean isActive, String suc_id, String[] transactions, Date creation_date) {
        super(account_id, client_id, balance, isActive, suc_id, transactions, creation_date);
    }

    public Current_Account(String client_id, Float balance, Boolean isActive, String suc_id, String[] transactions, Date creation_date) {
        super(client_id, balance, isActive, suc_id, transactions, creation_date);
    }

    public Current_Account() {
        //Constructor vacio
    }
    
}
