package com.kryshyna.ebank.dao;

import com.kryshyna.ebank.entity.Account;
import com.kryshyna.ebank.exception.DaoSystemException;
import com.kryshyna.ebank.exception.NoSuchEntityException;

import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public interface AccountDao {
    public void addAccount(Account account) throws DaoSystemException;

    public Account getAccount(int accountId) throws NoSuchEntityException;

    public void removeAccount(int personId, int accountId) throws NoSuchEntityException;

    public List<Account> getAllAccount(int personId) throws DaoSystemException;
}
