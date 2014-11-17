package com.kryshyna.ebank.dao.impl.hsql;

import com.kryshyna.ebank.dao.PersonDao;
import com.kryshyna.ebank.entity.Person;
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
public class HsqlPersonDao implements PersonDao {
    private Connection connection;

    public HsqlPersonDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Person> getAll() throws DaoSystemException {
        PreparedStatement statement = null;
        try {
            String query = "SELECT id, name, address FROM Persons";
            statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<Person> list = new ArrayList<>();
            Person person;
            while (resultSet.next()){
                person = new Person();
                person.setId(resultSet.getInt(1));
                person.setName(resultSet.getString(2));
                person.setAddress(resultSet.getString(3));
                list.add(person);
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
    public void addPerson(Person person) throws DaoSystemException {
        PreparedStatement statement = null;
        try {
            String query = "INSERT INTO Persons(name, address) VALUES(?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, person.getName());
            statement.setString(2, person.getAddress());
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
    public void removePerson(int id) throws NoSuchEntityException {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM Persons WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
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
    public Person getPerson(int id) throws NoSuchEntityException {
        PreparedStatement statement = null;
        try {
            String query = "SELECT id, name, address FROM Persons WHERE id=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Person person = new Person();
            if(resultSet.next()){
                person.setId(resultSet.getInt(1));
                person.setName(resultSet.getString(2));
                person.setAddress(resultSet.getString(3));
            }
            return person;
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
}
