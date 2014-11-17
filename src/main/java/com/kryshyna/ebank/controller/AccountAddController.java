package com.kryshyna.ebank.controller;

import com.kryshyna.ebank.dao.AccountDao;
import com.kryshyna.ebank.dao.BaseDaoFactory;
import com.kryshyna.ebank.entity.Account;
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
public class AccountAddController extends HttpServlet {
    private final String PARAMETER_PERSON_ID = "personId";
    private final String PARAMETER_TITLE = "title";
    private final String PAGE_OK = "person";
    private final String PAGE_ERROR = "index";

    private AccountDao accountDao = BaseDaoFactory.getInstance().getAccountDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strPersonId = request.getParameter(PARAMETER_PERSON_ID);
        String title = request.getParameter(PARAMETER_TITLE);
        try{
            if (strPersonId != null && title != null){
                int personId = Integer.valueOf(strPersonId);
                Account account = new Account(personId, 0, title);
                accountDao.addAccount(account);
                RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_OK+"?id="+personId);
                dispatcher.forward(request, response);
                return;
            }
        } catch (NumberFormatException | DaoSystemException e) {
//            e.printStackTrace();
        }
        response.sendRedirect(PAGE_ERROR);
    }
}
