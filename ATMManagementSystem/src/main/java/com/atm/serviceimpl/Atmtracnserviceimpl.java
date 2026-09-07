package com.atm.serviceimpl;

import java.util.List;

import com.atm.dao.Atmtransactiondao;
import com.atm.daoimpl.Atmtransactiondaoimpl;
import com.atm.model.Atmtransaction;
import com.atm.service.Atmtracnservice;

public class Atmtracnserviceimpl
        implements Atmtracnservice {

    private Atmtransactiondao transactionDAO =
            new Atmtransactiondaoimpl();

    @Override
    public boolean addTransaction(Atmtransaction transaction) {

        return transactionDAO.addTransaction(transaction);
    }

    @Override
    public List<Atmtransaction> getTransactions(int accountId) {

        return transactionDAO.getTransactions(accountId);
    }
}