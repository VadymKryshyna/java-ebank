package com.kryshyna.ebank.controller;

import com.kryshyna.ebank.dao.BaseDaoFactory;
import com.kryshyna.ebank.dao.PersonDao;
import com.kryshyna.ebank.entity.Person;
import com.kryshyna.ebank.exception.DaoSystemException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Vadym Kryshyna
 */
public class PersonAddController extends HttpServlet {
    private final String PARAMETER_NAME = "personName";
    private final String PARAMETER_ADDRESS = "personAddress";
    private final String PAGE_OK = "index";
    private final String PAGE_ERROR = "index";

    private PersonDao personDao = BaseDaoFactory.getInstance().getPersonDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter(PARAMETER_NAME);
        String address = request.getParameter(PARAMETER_ADDRESS);
        try{
            if (name != null && address != null){
                Person person = new Person(name, address);
                personDao.addPerson(person);
                RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_OK);
                dispatcher.forward(request, response);
                return;
            }
        } catch (DaoSystemException e) {
//            e.printStackTrace();
        }
        response.sendRedirect(PAGE_ERROR);
    }
}
