package com.allstate;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by localadmin on 7/28/16.
 */
public class Client {

    private String Id;
    private String name;
    private ArrayList<Account> accounts;
    private boolean isActive;

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public boolean isActive() {
        return isActive;
    }

    public Client(String name) {
        this.name = name;
        this.Id = UUID.randomUUID().toString();
        this.accounts = new ArrayList<>();
        this.isActive = true;

    }
    public void addAccount(Account account) {
        this.accounts.add(account);
    }


    public void closeAccount(String accountId) {
        Account foundAcct = this.accounts.stream().filter(a -> a.getId() == accountId).findFirst().get();
        foundAcct.withdraw(foundAcct.getBalance());


    }

}
