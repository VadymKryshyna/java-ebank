package com.kryshyna.ebank.dao;

import com.kryshyna.ebank.entity.TransactionFull;
import com.kryshyna.ebank.exception.DaoSystemException;
import com.kryshyna.ebank.exception.NoSuchEntityException;

import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public interface TransactionFullDao {
    public List<TransactionFull> getAllTransactionFull() throws DaoSystemException;

    public List<TransactionFull> getTransactionFullByAccountId(int accountId) throws NoSuchEntityException;

    public void addTransactionFull(TransactionFull transaction) throws DaoSystemException;

    public void removeTransactionFull(int transactionId) throws DaoSystemException;

}
