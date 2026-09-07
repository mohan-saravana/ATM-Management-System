package com.atm.serviceimpl;

import com.atm.dao.Atmaccountdao;
import com.atm.daoimpl.Atmaccountdaoimpl;
import com.atm.model.Atmaccount;
import com.atm.service.Atmaccservice;

public class Atmaccserviceimpl implements Atmaccservice {

    private Atmaccountdao accountDAO =
            new Atmaccountdaoimpl();

    @Override
    public Atmaccount getAccountByUserId(int userId) {

        return accountDAO.getAccountByUserId(userId);
    }

    @Override
    public boolean deposit(int accountId, double amount) {

        if (amount <= 0) {
            return false;
        }

        return accountDAO.deposit(accountId, amount);
    }

    @Override
    public boolean withdraw(int accountId, double amount) {

        if (amount <= 0) {
            return false;
        }

        return accountDAO.withdraw(accountId, amount);
    }

    @Override
    public boolean transfer(int fromAccountId,
                            int toAccountId,
                            double amount) {

        if (amount <= 0 ||
            fromAccountId == toAccountId) {

            return false;
        }

        return accountDAO.transfer(
                fromAccountId,
                toAccountId,
                amount);
    }
}