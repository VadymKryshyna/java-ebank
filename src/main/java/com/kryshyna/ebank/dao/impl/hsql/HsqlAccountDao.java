package com.kryshyna.ebank.dao.impl.hsql;

import com.kryshyna.ebank.dao.AccountDao;
import com.kryshyna.ebank.entity.Account;
import com.kryshyna.ebank.exception.DaoSystemException;
import com.kryshyna.ebank.exception.NoSuchEntityException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public class HsqlAccountDao implements AccountDao {
    private Connection connection;

    public HsqlAccountDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addAccount(Account account) throws DaoSystemException {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO Accounts(id_person, balance, title) VALUES(?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, account.getPersonId());
            statement.setInt(2, account.getBalance());
            statement.setString(3, account.getTitle());
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
    public Account getAccount(int accountId) throws NoSuchEntityException {
        PreparedStatement statement = null;
        try {
            String query = "SELECT id, id_person, balance, title FROM Accounts WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, accountId);
            ResultSet resultSet = statement.executeQuery();
            Account account = new Account();
            if (resultSet.next()){
                account.setId(resultSet.getInt(1));
                account.setPersonId(resultSet.getInt(2));
                account.setBalance(resultSet.getInt(3));
                account.setTitle(resultSet.getString(4));
            }
            return account;
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
    public void removeAccount(int personId, int accountId) throws NoSuchEntityException {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM Accounts WHERE id = ? AND id_person=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, accountId);
            statement.setInt(2, personId);
            statement.execute();
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
    public List<Account> getAllAccount(int personId) throws DaoSystemException {
        PreparedStatement statement = null;
        try {
            String query = "SELECT id, id_person, balance, title FROM Accounts WHERE id_person = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, personId);
            ResultSet resultSet = statement.executeQuery();
            List<Account> list = new ArrayList<>();
            Account account;
            while (resultSet.next()){
                account = new Account();
                account.setId(resultSet.getInt(1));
                account.setPersonId(resultSet.getInt(2));
                account.setBalance(resultSet.getInt(3));
                account.setTitle(resultSet.getString(4));
                list.add(account);
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
}
