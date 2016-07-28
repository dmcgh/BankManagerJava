package com.allstate;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by localadmin on 7/28/16.
 */
public class Account {
    private String id;
    private AccountType accountType;
    private ArrayList<Transaction> transactionArrayList;
    private float balance;
    private byte overdraftCount;
    private boolean isClosed;

    public Account(AccountType accountType) {
        this.accountType = accountType;
        this.id = UUID.randomUUID().toString();
        this.transactionArrayList = new ArrayList<>();
        this.balance = 0.0f;
        this.overdraftCount = 0;
        this.isClosed = false;

    }

    public void deposit(float amount){
        Transaction deposit = new Transaction(amount, TransactionType.DEPOSIT);
        this.balance += amount;
        this.transactionArrayList.add(deposit);
    }

    public void withdraw(float amount){

        if(amount > this.balance){
            this.balance -= 50f;
            Transaction fee = new Transaction(50f, TransactionType.FEE);
            this.overdraftCount += 1;
            this.transactionArrayList.add(fee);

            if(this.overdraftCount >= 3){
                this.isClosed = true;
            }
        }else {
            Transaction withdraw = new Transaction(amount, TransactionType.WITHDRAW);
            this.balance -= amount;
            this.transactionArrayList.add(withdraw);
        }

    }

    public String getId() {
        return id;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public ArrayList<Transaction> getTransactionArrayList() {
        return transactionArrayList;
    }

    public float getBalance() {
        return balance;
    }

    public boolean isClosed() {
        return isClosed;
    }
}
