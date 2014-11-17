package com.kryshyna.ebank.dao;

import com.kryshyna.ebank.entity.Person;
import com.kryshyna.ebank.exception.DaoSystemException;
import com.kryshyna.ebank.exception.NoSuchEntityException;

import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public interface PersonDao {
    public List<Person> getAll() throws DaoSystemException;

    public void addPerson(Person person) throws DaoSystemException;

    public void removePerson(int id) throws NoSuchEntityException;

    public Person getPerson(int id) throws NoSuchEntityException;
}
