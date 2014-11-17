package com.kryshyna.ebank.dao.impl.hsql;

import com.kryshyna.ebank.dao.TransactionFullDao;
import com.kryshyna.ebank.entity.TransactionFull;
import com.kryshyna.ebank.exception.DaoSystemException;
import com.kryshyna.ebank.exception.NoSuchEntityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public class HsqlTransactionFullDao implements TransactionFullDao {
    private Connection connection;

    public HsqlTransactionFullDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<TransactionFull> getAllTransactionFull() throws DaoSystemException {
        PreparedStatement statement = null;
        try {
            String query = "SELECT Transactions.id, Persons.id, Accounts.id Transactions.idAccountDebit,  Transactions.idAccountCredit, Transactions.sumTransaction FROM Transactions";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<TransactionFull> list = new ArrayList<>();
            TransactionFull transaction;
            while (resultSet.next()){
                transaction = new TransactionFull();
                transaction.setId(resultSet.getInt(1));
                transaction.setIdAccountDebit(resultSet.getInt(2));
                transaction.setIdAccountCredit(resultSet.getInt(3));
                transaction.setSumTransaction(resultSet.getInt(4));
                list.add(transaction);
            }
            return list;
        } catch (SQLException e) {
            throw new DaoSystemException("Sql exception");
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<TransactionFull> getTransactionFullByAccountId(int accountId) throws NoSuchEntityException {
        return null;
    }

    @Override
    public void addTransactionFull(TransactionFull transaction) throws DaoSystemException {

    }

    @Override
    public void removeTransactionFull(int transactionId) throws DaoSystemException {

    }
}
