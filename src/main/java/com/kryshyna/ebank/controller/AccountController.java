package com.kryshyna.ebank.controller;

import com.kryshyna.ebank.dao.AccountDao;
import com.kryshyna.ebank.dao.BaseDaoFactory;
import com.kryshyna.ebank.dao.TransactionDao;
import com.kryshyna.ebank.entity.Account;
import com.kryshyna.ebank.entity.Transaction;
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
public class AccountController extends HttpServlet {
    private final String PARAMETER_ID = "accountId";
    private final String PAGE_OK = "account.jsp";
    private final String PAGE_ERROR = "index";
    private final String ATTRIBUTE_ACCOUNT = "account";
    private final String ATTRIBUTE_MODEL_TO_VIEW = "model";


    private TransactionDao transactionDao = BaseDaoFactory.getInstance().getTransactionDao();
    private AccountDao accountDao = BaseDaoFactory.getInstance().getAccountDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strId = request.getParameter(PARAMETER_ID);
        try{
            if (strId != null){
                int id = Integer.parseInt(strId);
                Account account = accountDao.getAccount(id);
                request.setAttribute(ATTRIBUTE_ACCOUNT, account);
                try {
                    List<Transaction> model =  transactionDao.getTransactionByAccountId(id);
                    request.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
                } catch (NoSuchEntityException e) {
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
