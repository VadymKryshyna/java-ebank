package com.kryshyna.ebank.entity;

/**
 * @author Vadym Kryshyna
 */
public class Transaction {
    private int id;
    private int idAccountDebit;
    private int idAccountCredit;
    private int sumTransaction;

    public Transaction() {
    }

    public Transaction(int idAccountDebit, int idAccountCredit, int sumTransaction) {
        this.idAccountDebit = idAccountDebit;
        this.idAccountCredit = idAccountCredit;
        this.sumTransaction = sumTransaction;
    }

    public Transaction(int id, int idAccountDebit, int idAccountCredit, int sumTransaction) {
        this.id = id;
        this.idAccountDebit = idAccountDebit;
        this.idAccountCredit = idAccountCredit;
        this.sumTransaction = sumTransaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAccountDebit() {
        return idAccountDebit;
    }

    public void setIdAccountDebit(int idAccountDebit) {
        this.idAccountDebit = idAccountDebit;
    }

    public int getIdAccountCredit() {
        return idAccountCredit;
    }

    public void setIdAccountCredit(int idAccountCredit) {
        this.idAccountCredit = idAccountCredit;
    }

    public int getSumTransaction() {
        return sumTransaction;
    }

    public void setSumTransaction(int sumTransaction) {
        this.sumTransaction = sumTransaction;
    }
}
