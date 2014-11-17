package com.kryshyna.ebank.dao;

import com.kryshyna.ebank.dao.impl.hsql.HsqlDaoFactory;

/**
 * @author Vadym Kryshyna
 */
public class BaseDaoFactory {
    private static DaoFactory instance;

    private BaseDaoFactory(){
    }

    public static DaoFactory getInstance(){
        if(instance == null){
            instance = new HsqlDaoFactory();
//            instance = new OtherDaoFactory();
        }
        return instance;
    }
}
