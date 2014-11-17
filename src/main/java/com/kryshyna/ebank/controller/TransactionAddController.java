package com.kryshyna.ebank.controller;

import com.kryshyna.ebank.dao.BaseDaoFactory;
import com.kryshyna.ebank.dao.TransactionDao;
import com.kryshyna.ebank.entity.Transaction;
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
public class TransactionAddController extends HttpServlet {
    private final String PARAMETER_ACCOUNT_DEBIT_ID = "debit";
    private final String PARAMETER_ACCOUNT_CREDIT_ID = "credit";
    private final String PARAMETER_SUM = "sum";
    private final String PARAMETER_ACCOUNT_ID = "accountId";
    private final String PAGE_OK_ACCOUNT = "account";
    private final String PAGE_OK_ALL = "transaction";
    private final String PAGE_ERROR = "index";

    private TransactionDao transactionDao = BaseDaoFactory.getInstance().getTransactionDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String strDebitId = request.getParameter(PARAMETER_ACCOUNT_DEBIT_ID);
        String strCreditId = request.getParameter(PARAMETER_ACCOUNT_CREDIT_ID);
        String strSum = request.getParameter(PARAMETER_SUM);
        String strAccountId = request.getParameter(PARAMETER_ACCOUNT_ID);
        try{
            if (strDebitId != null && strCreditId != null && strSum != null){
                int debitId = Integer.valueOf(strDebitId);
                int creditId = Integer.valueOf(strCreditId);
                int sum = Integer.valueOf(strSum);
                Transaction transaction = new Transaction();
                transaction.setIdAccountDebit(debitId);
                transaction.setIdAccountCredit(creditId);
                transaction.setSumTransaction(sum);
                transactionDao.addTransaction(transaction);
            }
            if(strAccountId != null){
                int accountId = Integer.valueOf(strAccountId);
                RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE_OK_ACCOUNT + "?id="+accountId);
                dispatcher.forward(request, response);
                return;
            }else{
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
