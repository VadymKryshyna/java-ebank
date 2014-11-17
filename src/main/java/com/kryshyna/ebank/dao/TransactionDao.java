package com.kryshyna.ebank.dao;

import com.kryshyna.ebank.entity.Transaction;
import com.kryshyna.ebank.exception.DaoSystemException;
import com.kryshyna.ebank.exception.NoSuchEntityException;

import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public interface TransactionDao {

    public List<Transaction> getAllTransaction() throws DaoSystemException;

    public List<Transaction> getTransactionByAccountId(int accountId) throws NoSuchEntityException;

    public void addTransaction(Transaction transaction) throws DaoSystemException;

    public void removeTransaction(int transactionId) throws DaoSystemException;

}
