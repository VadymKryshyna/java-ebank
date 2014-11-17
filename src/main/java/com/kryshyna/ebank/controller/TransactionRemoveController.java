package com.kryshyna.ebank.controller;

import com.kryshyna.ebank.dao.BaseDaoFactory;
import com.kryshyna.ebank.dao.TransactionDao;
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
public class TransactionRemoveController extends HttpServlet {
    private final String PARAMETER_ACCOUNT_ID = "accountId";
    private final String PARAMETER_TRANSACTION_ID = "transactionId";
    private final String PAGE_OK_ACCOUNT = "account";
    private final String PAGE_OK_ALL = "transaction";
    private final String PAGE_ERROR = "index";

    private TransactionDao transactionDao = BaseDaoFactory.getInstance().getTransactionDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strTransactionId = request.getParameter(PARAMETER_TRANSACTION_ID);
        String strAccountId = request.getParameter(PARAMETER_ACCOUNT_ID);
        try{
            if (strTransactionId != null && strAccountId != null){
                int transactionId = Integer.valueOf(strTransactionId);
                int accountId = Integer.valueOf(strAccountId);
                transactionDao.removeTransaction(transactionId);
                RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_OK_ACCOUNT+"?id="+accountId);
                dispatcher.forward(request, response);
                return;
            }else if(strTransactionId != null){
                int transactionId = Integer.valueOf(strTransactionId);
                transactionDao.removeTransaction(transactionId);
                RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_OK_ALL);
                dispatcher.forward(request, response);
                return;
            }
        } catch (NumberFormatException | DaoSystemException e) {
//            e.printStackTrace();
        }
        response.sendRedirect(PAGE_ERROR);
    }

}
