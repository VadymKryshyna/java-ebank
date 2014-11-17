package com.kryshyna.ebank.entity;

/**
 * @author Vadym Kryshyna
 */
public class Account {
    private int id;
    private int personId;
    private int balance;
    private String title;

    public Account() {
    }

    public Account(int personId, int balance, String title) {
        this.personId = personId;
        this.balance = balance;
        this.title = title;
    }

    public Account(int id, int personId, int balance, String title) {

        this.id = id;
        this.personId = personId;
        this.balance = balance;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
