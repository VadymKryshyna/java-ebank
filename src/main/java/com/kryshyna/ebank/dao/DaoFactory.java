package com.kryshyna.ebank.dao;


/**
 * @author Vadym Kryshyna
 */
public interface DaoFactory {
    public PersonDao getPersonDao();

    public AccountDao getAccountDao();

    public TransactionDao getTransactionDao();

    public TransactionFullDao getTransactionFullDao();

}
