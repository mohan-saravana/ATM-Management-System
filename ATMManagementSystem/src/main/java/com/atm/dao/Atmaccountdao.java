package com.atm.dao;

import com.atm.model.Atmaccount;

public interface Atmaccountdao {

    Atmaccount getAccountByUserId(int userId);

    boolean deposit(int accountId, double amount);

    boolean withdraw(int accountId, double amount);

    boolean transfer(int fromAccountId,
                     int toAccountId,
                     double amount);
}