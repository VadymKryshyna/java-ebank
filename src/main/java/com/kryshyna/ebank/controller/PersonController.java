package com.kryshyna.ebank.controller;

import com.kryshyna.ebank.dao.AccountDao;
import com.kryshyna.ebank.dao.BaseDaoFactory;
import com.kryshyna.ebank.dao.PersonDao;
import com.kryshyna.ebank.entity.Account;
import com.kryshyna.ebank.entity.Person;
import com.kryshyna.ebank.exception.DaoSystemException;
import com.kryshyna.ebank.exception.NoSuchEntityException;

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
public class PersonController extends HttpServlet {
    private final String PARAMETER_ID = "id";
    private final String PAGE_OK = "person.jsp";
    private final String PAGE_ERROR = "index";
    private final String ATTRIBUTE_PERSON = "person";
    private final String ATTRIBUTE_MODEL_TO_VIEW = "model";


    private PersonDao personDao = BaseDaoFactory.getInstance().getPersonDao();
    private AccountDao accountDao = BaseDaoFactory.getInstance().getAccountDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter(PARAMETER_ID);
        try{
            if (strId != null){
                int id = Integer.parseInt(strId);
                Person person = personDao.getPerson(id);
                request.setAttribute(ATTRIBUTE_PERSON, person);
                try {
                    List<Account> model =  accountDao.getAllAccount(id);
                    request.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
                } catch (DaoSystemException e) {
//                    e.printStackTrace();
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_OK);
                dispatcher.forward(request, response);
                return;
            }
        } catch (NoSuchEntityException e) {
//            e.printStackTrace();
        }
        response.sendRedirect(PAGE_ERROR);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
