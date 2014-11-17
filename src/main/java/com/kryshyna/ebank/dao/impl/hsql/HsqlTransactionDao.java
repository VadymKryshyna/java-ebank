package com.kryshyna.ebank.dao.impl.hsql;

import com.kryshyna.ebank.dao.TransactionDao;
import com.kryshyna.ebank.entity.Transaction;
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
public class HsqlTransactionDao implements TransactionDao {
    private Connection connection;

    public HsqlTransactionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Transaction> getAllTransaction() throws DaoSystemException {
        PreparedStatement statement = null;
        try {
            String query = "SELECT id, idAccountDebit, idAccountCredit, sumTransaction FROM Transactions";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<Transaction> list = new ArrayList<>();
            Transaction transaction;
            while (resultSet.next()){
                transaction = new Transaction();
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
    public List<Transaction> getTransactionByAccountId(int accountId) throws NoSuchEntityException {
        PreparedStatement statement = null;
        try {
            String query = "SELECT id, idAccountDebit, idAccountCredit, sumTransaction " +
                    "FROM Transactions WHERE idAccountDebit = ? OR idAccountCredit = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, accountId);
            statement.setInt(2, accountId);
            ResultSet resultSet = statement.executeQuery();
            List<Transaction> list = new ArrayList<>();
            Transaction transaction;
            while (resultSet.next()){
                transaction = new Transaction();
                transaction.setId(resultSet.getInt(1));
                transaction.setIdAccountDebit(resultSet.getInt(2));
                transaction.setIdAccountCredit(resultSet.getInt(3));
                transaction.setSumTransaction(resultSet.getInt(4));
                list.add(transaction);
            }
            return list;
        } catch (SQLException e) {
            throw new NoSuchEntityException("Sql exception");
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
    public void addTransaction(Transaction transaction) throws DaoSystemException {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO Transactions(idAccountDebit, idAccountCredit, sumTransaction) VALUES(?, ?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, transaction.getIdAccountDebit());
            statement.setInt(2, transaction.getIdAccountCredit());
            statement.setInt(3, transaction.getSumTransaction());
            statement.execute();
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
    public void removeTransaction(int transactionId) throws DaoSystemException {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM Transactions WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, transactionId);
            statement.execute();
            statement.close();
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
}
