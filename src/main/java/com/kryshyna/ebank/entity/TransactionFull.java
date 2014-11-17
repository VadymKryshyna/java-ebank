package com.kryshyna.ebank.entity;

/**
 * @author Vadym Kryshyna
 */
public class TransactionFull {
    private int id;
    private int idPersonFrom;
    private String namePersonFrom;
    private int idAccountDebit;
    private String titleAccountDebit;
    private int idPersonTo;
    private String namePersonTo;
    private int idAccountCredit;
    private String titleAccountCredit;
    private int sumTransaction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPersonFrom() {
        return idPersonFrom;
    }

    public void setIdPersonFrom(int idPersonFrom) {
        this.idPersonFrom = idPersonFrom;
    }

    public String getNamePersonFrom() {
        return namePersonFrom;
    }

    public void setNamePersonFrom(String namePersonFrom) {
        this.namePersonFrom = namePersonFrom;
    }

    public int getIdAccountDebit() {
        return idAccountDebit;
    }

    public void setIdAccountDebit(int idAccountDebit) {
        this.idAccountDebit = idAccountDebit;
    }

    public String getTitleAccountDebit() {
        return titleAccountDebit;
    }

    public void setTitleAccountDebit(String titleAccountDebit) {
        this.titleAccountDebit = titleAccountDebit;
    }

    public int getIdPersonTo() {
        return idPersonTo;
    }

    public void setIdPersonTo(int idPersonTo) {
        this.idPersonTo = idPersonTo;
    }

    public String getNamePersonTo() {
        return namePersonTo;
    }

    public void setNamePersonTo(String namePersonTo) {
        this.namePersonTo = namePersonTo;
    }

    public int getIdAccountCredit() {
        return idAccountCredit;
    }

    public void setIdAccountCredit(int idAccountCredit) {
        this.idAccountCredit = idAccountCredit;
    }

    public String getTitleAccountCredit() {
        return titleAccountCredit;
    }

    public void setTitleAccountCredit(String titleAccountCredit) {
        this.titleAccountCredit = titleAccountCredit;
    }

    public int getSumTransaction() {
        return sumTransaction;
    }

    public void setSumTransaction(int sumTransaction) {
        this.sumTransaction = sumTransaction;
    }
}
