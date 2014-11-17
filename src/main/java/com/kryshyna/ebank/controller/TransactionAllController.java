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
import java.util.List;

/**
 * @author Vadym Kryshyna
 */
public class TransactionAllController extends HttpServlet {
    private final String PAGE_OK = "transaction.jsp";
    private final String PAGE_ERROR = "index";
    private final String ATTRIBUTE_MODEL_TO_VIEW = "model";


    private TransactionDao transactionDao = BaseDaoFactory.getInstance().getTransactionDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            List<Transaction> model =  transactionDao.getAllTransaction();
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
