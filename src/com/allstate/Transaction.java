package com.allstate;

import java.util.Date;
import java.util.UUID;

/**
 * Created by localadmin on 7/28/16.
 */
public class Transaction {

    private String id;
    private float amount;
    private Date date;
    private TransactionType transactionType;


    public Transaction(float amount, TransactionType transactionType ) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.transactionType = transactionType;
        this.date = new Date();
      }

    public void deleteme(){

    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction Type: " + this.transactionType + ", Amount: " + this.amount;
    }
}
