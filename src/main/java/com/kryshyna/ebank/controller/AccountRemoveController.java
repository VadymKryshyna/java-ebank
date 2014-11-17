package com.kryshyna.ebank.controller;

import com.kryshyna.ebank.dao.AccountDao;
import com.kryshyna.ebank.dao.BaseDaoFactory;
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
public class AccountRemoveController extends HttpServlet {
    private final String PARAMETER_PERSON_ID = "personId";
    private final String PARAMETER_ACCOUNT_ID = "accountId";
    private final String PAGE_OK = "person";
    private final String PAGE_ERROR = "index";

    private AccountDao accountDao = BaseDaoFactory.getInstance().getAccountDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strPersonId = request.getParameter(PARAMETER_PERSON_ID);
        String strAccountId = request.getParameter(PARAMETER_ACCOUNT_ID);
        try{
            if (strPersonId != null && strAccountId != null){
                int personId = Integer.valueOf(strPersonId);
                int accountId = Integer.valueOf(strAccountId);
                accountDao.removeAccount(personId, accountId);
                RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_OK+"?id="+personId);
                dispatcher.forward(request, response);
                return;
            }
        } catch (NumberFormatException | NoSuchEntityException e) {
//            e.printStackTrace();
        }
        response.sendRedirect(PAGE_ERROR);
    }

}
