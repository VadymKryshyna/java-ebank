package com.kryshyna.ebank.controller;

import com.kryshyna.ebank.dao.BaseDaoFactory;
import com.kryshyna.ebank.dao.PersonDao;
import com.kryshyna.ebank.exception.NoSuchEntityException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Vadym Kryshyna
 */
public class PersonRemoveController extends HttpServlet {
    private final String PARAMETER_ID = "id";
    private final String PAGE_OK = "index";
    private final String PAGE_ERROR = "index";

    private PersonDao personDao = BaseDaoFactory.getInstance().getPersonDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter(PARAMETER_ID);
        try{
            if (strId != null){
                int id = Integer.parseInt(strId);
                personDao.removePerson(id);
                RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_OK);
                dispatcher.forward(request, response);
                return;
            }
        } catch (NumberFormatException | NoSuchEntityException e) {
//            e.printStackTrace();
        }
        response.sendRedirect(PAGE_ERROR);
    }
}
