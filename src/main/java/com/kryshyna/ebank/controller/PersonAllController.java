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
import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public class PersonAllController extends HttpServlet {
    public final String PAGE_OK = "/index.jsp";
    public final String PAGE_ERROR = "/index.jsp";
    public final String ATTRIBUTE_MODEL_TO_VIEW = "model";

    private PersonDao personDao = BaseDaoFactory.getInstance().getPersonDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Person> model = personDao.getAll();
            request.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
            RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_OK);
            dispatcher.forward(request, response);
            return;
        } catch (DaoSystemException e) {
//            e.printStackTrace();
        }
        response.sendRedirect(PAGE_ERROR);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
